package com.example.todoApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.todoApi.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query(value="SELECT * FROM todo WHERE user_id = ?", nativeQuery= true)
    public List<Todo> getByUserId(Long user_id);
}
