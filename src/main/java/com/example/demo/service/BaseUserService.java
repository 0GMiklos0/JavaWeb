package com.example.demo.service;

import com.example.demo.model.BaseUser;

import java.util.List;

public interface BaseUserService {
    public void registerUser(String userName, String password);
    public List<BaseUser> findAll();
}
