package com.example.demo.web;

import com.example.demo.model.BaseUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface BaseController {
    @GetMapping("/")
    public List<BaseUser> allUsers();

    @PostMapping("/")
    public void registerUser(String userName, String password);
}
