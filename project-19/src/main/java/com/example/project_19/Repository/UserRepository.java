package com.example.project_19.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project_19.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByToken(String token);
    boolean existsByToken(String token);
}