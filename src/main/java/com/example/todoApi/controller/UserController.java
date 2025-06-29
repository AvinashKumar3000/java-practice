package com.example.todoApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoApi.dto.RegisterData;
import com.example.todoApi.entity.User;
import com.example.todoApi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    // Dependency injection (DI)
    private final UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterData body) {
        User newUser = new User();
        newUser.setEmail(body.getEmail());
        newUser.setPassword(body.getPassword());
        try {
            userRepository.save(newUser);
            return "Registration successfull.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody RegisterData body) {
        List<User> allUsers = userRepository.findAll();
        for (User user : allUsers) {
            if(user.getEmail().equals(body.getEmail()) && user.getPassword().equals(body.getPassword())) {
                return "Login successfull :" + user.getId().toString();
            }
        }
        return "Login unsuccessfull";
    }

}