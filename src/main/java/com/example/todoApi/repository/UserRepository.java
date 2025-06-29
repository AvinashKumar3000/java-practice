package com.example.todoApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoApi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
