package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());
        return repository.save(existing);
    }

    public boolean deleteUser(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
