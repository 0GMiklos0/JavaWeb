package com.example.demo.web;

import com.example.demo.model.BaseUser;
import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.security.Principal;
import java.util.List;

public interface BaseController {
    @GetMapping("/")
    List<BaseUser> allUsers();

    @PostMapping("/register")
    void registerUser(String userName, String password);

    @PostMapping("/login")
    LoginResponse login(LoginRequest credentials);
}
