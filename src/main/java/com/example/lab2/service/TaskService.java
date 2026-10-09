package com.example.lab2.service;
import com.example.lab2.dto.TaskDto;
import com.example.lab2.entity.DevelopmentTask;
import com.example.lab2.repository.DataStore;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class TaskService {
    private final DataStore store;
    public TaskService(DataStore store) { this.store = store; }
    public List<DevelopmentTask> findAll() { return store.findAllTasks(); }
    public DevelopmentTask findById(Long id) { return store.findTaskById(id); }
    public DevelopmentTask create(TaskDto dto) {
        DevelopmentTask t = new DevelopmentTask();
        if (dto.getProductId() != null) t.setProduct(store.findProductById(dto.getProductId()));
        if (dto.getAssigneeId() != null) t.setAssignee(store.findUserById(dto.getAssigneeId()));
        t.setVersion(dto.getVersion());
        t.setStatus(dto.getStatus());
        return store.saveTask(t);
    }
    public DevelopmentTask update(Long id, Map<String, Object> patch) {
        DevelopmentTask t = store.findTaskById(id);
        if (t == null) return null;
        if (patch.containsKey("version")) t.setVersion((String) patch.get("version"));
        if (patch.containsKey("status")) t.setStatus((String) patch.get("status"));
        if (patch.containsKey("productId")) {
            Long pid = ((Number) patch.get("productId")).longValue();
            t.setProduct(store.findProductById(pid));
        }
        if (patch.containsKey("assigneeId")) {
            Long aid = ((Number) patch.get("assigneeId")).longValue();
            t.setAssignee(store.findUserById(aid));
        }
        return store.updateTask(t);
    }
    public boolean delete(Long id) {
        if (store.findTaskById(id) == null) return false;
        store.deleteTask(id);
        return true;
    }
}
