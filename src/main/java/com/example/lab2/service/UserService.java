package com.example.lab2.service;

import com.example.lab2.dto.UserDto;
import com.example.lab2.entity.User;
import com.example.lab2.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    private final UserRepository repo;
    public UserService(UserRepository repo) { this.repo = repo; }

    public List<User> findAll() { return repo.findAll(); }
    public User findById(Long id) { return repo.findById(id).orElse(null); }

    public User create(UserDto dto) {
        User u = new User(dto.getUsername(), dto.getEmail());
        return repo.save(u);
    }

    public User update(Long id, Map<String, Object> patch) {
        User u = repo.findById(id).orElse(null);
        if (u == null) return null;
        if (patch.containsKey("username")) u.setUsername((String) patch.get("username"));
        if (patch.containsKey("email")) u.setEmail((String) patch.get("email"));
        return repo.save(u);
    }

    public boolean delete(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
