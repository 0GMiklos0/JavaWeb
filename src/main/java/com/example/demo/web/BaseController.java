package com.example.demo.web;

import com.example.demo.model.BaseUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface BaseController {
    @GetMapping("/")
    public List<BaseUser> allUsers();

    @PutMapping("/")
    public void registerUser(String userName, String password);

    @PostMapping("/")
    public void login(String userName, String password);
}
