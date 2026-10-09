package com.example.lab2.service;
import com.example.lab2.dto.UserDto;
import com.example.lab2.entity.User;
import com.example.lab2.repository.DataStore;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class UserService {
    private final DataStore store;
    public UserService(DataStore store) { this.store = store; }
    public List<User> findAll() { return store.findAllUsers(); }
    public User findById(Long id) { return store.findUserById(id); }
    public User create(UserDto dto) {
        User u = new User();
        u.setUsername(dto.getUsername());
        u.setEmail(dto.getEmail());
        return store.saveUser(u);
    }
    public User update(Long id, Map<String, Object> patch) {
        User u = store.findUserById(id);
        if (u == null) return null;
        if (patch.containsKey("username")) u.setUsername((String) patch.get("username"));
        if (patch.containsKey("email")) u.setEmail((String) patch.get("email"));
        return store.updateUser(u);
    }
    public boolean delete(Long id) {
        if (store.findUserById(id) == null) return false;
        store.deleteUser(id);
        return true;
    }
}
