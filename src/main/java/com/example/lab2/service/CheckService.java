package com.example.lab2.service;
import com.example.lab2.dto.CheckDto;
import com.example.lab2.entity.ReleaseCheck;
import com.example.lab2.repository.DataStore;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
@Service
public class CheckService {
    private final DataStore store;
    public CheckService(DataStore store) { this.store = store; }
    public List<ReleaseCheck> findAll() { return store.findAllChecks(); }
    public ReleaseCheck findById(Long id) { return store.findCheckById(id); }
    public ReleaseCheck create(CheckDto dto) {
        ReleaseCheck c = new ReleaseCheck();
        if (dto.getReleaseId() != null) c.setRelease(store.findReleaseById(dto.getReleaseId()));
        c.setCheckName(dto.getCheckName());
        c.setMandatory(dto.isMandatory());
        c.setResult(dto.getResult());
        c.setCheckedAt(LocalDateTime.now());
        return store.saveCheck(c);
    }
    public ReleaseCheck update(Long id, Map<String, Object> patch) {
        ReleaseCheck c = store.findCheckById(id);
        if (c == null) return null;
        if (patch.containsKey("checkName")) c.setCheckName((String) patch.get("checkName"));
        if (patch.containsKey("mandatory")) c.setMandatory((Boolean) patch.get("mandatory"));
        if (patch.containsKey("result")) c.setResult((String) patch.get("result"));
        if (patch.containsKey("releaseId")) {
            Long rid = ((Number) patch.get("releaseId")).longValue();
            c.setRelease(store.findReleaseById(rid));
        }
        return store.updateCheck(c);
    }
    public boolean delete(Long id) {
        if (store.findCheckById(id) == null) return false;
        store.deleteCheck(id);
        return true;
    }
}
