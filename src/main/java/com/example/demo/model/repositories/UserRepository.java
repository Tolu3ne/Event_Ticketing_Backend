package com.example.demo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;


public interface UserRepository extends JpaRepository<User, Object> {
    User findById(long id);
    User findByUsername(String username);
    User findByEmail(String email);
}
