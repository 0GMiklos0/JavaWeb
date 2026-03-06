package com.example.demo.service;

import com.example.demo.model.BaseUser;
import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.Principal;
import java.util.List;

public interface BaseUserService extends UserDetailsService {
    void registerUser(String userName, String password);
    List<BaseUser> findAll();
    BaseUser findOne(String userName);
    void changeMyData(BaseUser currentUser, BaseUser newUser);
    LoginResponse login(LoginRequest credentials);
}
