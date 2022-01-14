package com.alex.kata_3_1_2.repository;

import com.alex.kata_3_1_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
