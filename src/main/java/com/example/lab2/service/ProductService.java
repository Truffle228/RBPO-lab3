package com.example.lab2.service;
import com.example.lab2.dto.ProductDto;
import com.example.lab2.entity.SoftwareProduct;
import com.example.lab2.repository.DataStore;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ProductService {
    private final DataStore store;
    public ProductService(DataStore store) { this.store = store; }
    public List<SoftwareProduct> findAll() { return store.findAllProducts(); }
    public SoftwareProduct findById(Long id) { return store.findProductById(id); }
    public SoftwareProduct create(ProductDto dto) {
        SoftwareProduct p = new SoftwareProduct();
        p.setName(dto.getName());
        if (dto.getResponsibleId() != null) p.setResponsible(store.findUserById(dto.getResponsibleId()));
        return store.saveProduct(p);
    }
    public SoftwareProduct update(Long id, Map<String, Object> patch) {
        SoftwareProduct p = store.findProductById(id);
        if (p == null) return null;
        if (patch.containsKey("name")) p.setName((String) patch.get("name"));
        if (patch.containsKey("responsibleId")) {
            Long rid = ((Number) patch.get("responsibleId")).longValue();
            p.setResponsible(store.findUserById(rid));
        }
        return store.updateProduct(p);
    }
    public boolean delete(Long id) {
        if (store.findProductById(id) == null) return false;
        store.deleteProduct(id);
        return true;
    }
}
