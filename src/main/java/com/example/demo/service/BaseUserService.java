package com.example.demo.service;

import com.example.demo.model.BaseUser;

import java.util.List;

public interface BaseUserService {
    void registerUser(String userName, String password);
    List<BaseUser> findAll();
    BaseUser findOne(String userName);
    void changeMyData(BaseUser currentUser, BaseUser newUser);
}
