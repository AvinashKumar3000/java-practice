package com.example.todoApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoApi.entity.Todo;
import com.example.todoApi.entity.User;
import com.example.todoApi.repository.TodoRepository;
import com.example.todoApi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @GetMapping("/by/{user_id}")
    public List<Todo> getById(@PathVariable Long user_id) {
        return this.todoRepository.getByUserId(user_id);
    }

    @PostMapping("/by/{user_id}/item/{task}")
    public String addItem(@PathVariable Long user_id, @PathVariable String task) {
        User existingUser = this.userRepository.findById(user_id).orElse(null);
        if(existingUser == null) {
            return "user with userid not exists.";
        }
        Todo newItem = new Todo();
        newItem.setTask(task);
        newItem.setIs_completed(false);
        newItem.setUser(existingUser);
        this.todoRepository.save(newItem);
        return "added successfully";
    }
}
