package com.example.project_15.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project_15.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}