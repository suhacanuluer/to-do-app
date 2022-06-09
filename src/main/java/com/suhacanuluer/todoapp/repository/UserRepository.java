package com.suhacanuluer.todoapp.repository;

import com.suhacanuluer.todoapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    Boolean existsByUsername(String username);
}
