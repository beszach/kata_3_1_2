package com.alex.kata_3_1_2.service;

import com.alex.kata_3_1_2.model.Role;

import java.util.List;

public interface RoleService {
    void add(Role roleName);
    List<Role> getAll();
}
