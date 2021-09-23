package com.example.api.dao;

import com.example.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    boolean existsByName(String name);
    void deleteByName(String name);
    User findByName(String name);
}
