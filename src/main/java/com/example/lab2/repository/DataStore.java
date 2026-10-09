package com.example.lab2.repository;

import com.example.lab2.entity.*;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class DataStore {
    private final AtomicLong idGen = new AtomicLong(1);
    private final Map<Long, User> users = new LinkedHashMap<>();
    private final Map<Long, SoftwareProduct> products = new LinkedHashMap<>();
    private final Map<Long, DevelopmentTask> tasks = new LinkedHashMap<>();
    private final Map<Long, Release> releases = new LinkedHashMap<>();
    private final Map<Long, ReleaseCheck> checks = new LinkedHashMap<>();

    public long nextId() { return idGen.getAndIncrement(); }

    public List<User> findAllUsers() { return new ArrayList<>(users.values()); }
    public User findUserById(Long id) { return users.get(id); }
    public User saveUser(User u) { if (u.getId() == null) u.setId(nextId()); users.put(u.getId(), u); return u; }
    public User updateUser(User u) { users.put(u.getId(), u); return u; }
    public void deleteUser(Long id) {
        users.remove(id);
        products.values().forEach(p -> { if (p.getResponsible() != null && p.getResponsible().getId().equals(id)) p.setResponsible(null); });
        tasks.values().forEach(t -> { if (t.getAssignee() != null && t.getAssignee().getId().equals(id)) t.setAssignee(null); });
    }

    public List<SoftwareProduct> findAllProducts() { return new ArrayList<>(products.values()); }
    public SoftwareProduct findProductById(Long id) { return products.get(id); }
    public SoftwareProduct saveProduct(SoftwareProduct p) { if (p.getId() == null) p.setId(nextId()); products.put(p.getId(), p); return p; }
    public SoftwareProduct updateProduct(SoftwareProduct p) { products.put(p.getId(), p); return p; }
    public void deleteProduct(Long id) {
        products.remove(id);
        tasks.values().removeIf(t -> t.getProduct() != null && t.getProduct().getId().equals(id));
        releases.values().removeIf(r -> r.getProduct() != null && r.getProduct().getId().equals(id));
    }

    public List<DevelopmentTask> findAllTasks() { return new ArrayList<>(tasks.values()); }
    public DevelopmentTask findTaskById(Long id) { return tasks.get(id); }
    public DevelopmentTask saveTask(DevelopmentTask t) { if (t.getId() == null) t.setId(nextId()); tasks.put(t.getId(), t); return t; }
    public DevelopmentTask updateTask(DevelopmentTask t) { tasks.put(t.getId(), t); return t; }
    public void deleteTask(Long id) { tasks.remove(id); }

    public List<Release> findAllReleases() { return new ArrayList<>(releases.values()); }
    public Release findReleaseById(Long id) { return releases.get(id); }
    public Release saveRelease(Release r) { if (r.getId() == null) r.setId(nextId()); releases.put(r.getId(), r); return r; }
    public Release updateRelease(Release r) { releases.put(r.getId(), r); return r; }
    public void deleteRelease(Long id) {
        checks.values().removeIf(c -> c.getRelease() != null && c.getRelease().getId().equals(id));
        products.values().forEach(p -> { if (p.getCurrentVersion() != null && p.getCurrentVersion().getId().equals(id)) p.setCurrentVersion(null); });
        releases.remove(id);
    }

    public List<ReleaseCheck> findAllChecks() { return new ArrayList<>(checks.values()); }
    public ReleaseCheck findCheckById(Long id) { return checks.get(id); }
    public ReleaseCheck saveCheck(ReleaseCheck c) { if (c.getId() == null) c.setId(nextId()); checks.put(c.getId(), c); return c; }
    public ReleaseCheck updateCheck(ReleaseCheck c) { checks.put(c.getId(), c); return c; }
    public void deleteCheck(Long id) { checks.remove(id); }
}
