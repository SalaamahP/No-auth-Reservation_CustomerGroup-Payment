package com.restaurant.rms.service;

import com.restaurant.rms.models.User;
import com.restaurant.rms.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public UserService(UserRepo userRepo) {
        this.repo = userRepo;
    }
    // ----------------------------------

    public User add(User user) {
        return repo.save(user);
    }

    public User read(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User update(User user) {
        return repo.save(user);
    }

    public boolean delete(int id) {
        repo.deleteById(id);
        return true;
    }
}
