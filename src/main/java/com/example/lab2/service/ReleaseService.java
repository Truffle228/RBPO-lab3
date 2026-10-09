package com.example.lab2.service;
import com.example.lab2.dto.ReleaseDto;
import com.example.lab2.entity.Release;
import com.example.lab2.repository.DataStore;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
@Service
public class ReleaseService {
    private final DataStore store;
    public ReleaseService(DataStore store) { this.store = store; }
    public List<Release> findAll() { return store.findAllReleases(); }
    public Release findById(Long id) { return store.findReleaseById(id); }
    public Release create(ReleaseDto dto) {
        Release r = new Release();
        if (dto.getProductId() != null) r.setProduct(store.findProductById(dto.getProductId()));
        r.setNumber(dto.getNumber());
        r.setStatus(dto.getStatus());
        r.setReleaseDate(LocalDateTime.now());
        return store.saveRelease(r);
    }
    public Release update(Long id, Map<String, Object> patch) {
        Release r = store.findReleaseById(id);
        if (r == null) return null;
        if (patch.containsKey("number")) r.setNumber((String) patch.get("number"));
        if (patch.containsKey("status")) r.setStatus((String) patch.get("status"));
        if (patch.containsKey("productId")) {
            Long pid = ((Number) patch.get("productId")).longValue();
            r.setProduct(store.findProductById(pid));
        }
        return store.updateRelease(r);
    }
    public boolean delete(Long id) {
        if (store.findReleaseById(id) == null) return false;
        store.deleteRelease(id);
        return true;
    }
}
