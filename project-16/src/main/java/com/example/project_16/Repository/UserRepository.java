package com.example.project_16.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project_16.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}