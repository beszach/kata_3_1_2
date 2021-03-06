package com.alex.kata_3_1_2.service;

import com.alex.kata_3_1_2.model.User;

import java.util.List;


public interface UserService {
    User findByEmail(String email);
    void add(User model);
    void update(User model);
    void delete(Long id);
    List<User> getAll();
    User getById(Long id);
}
