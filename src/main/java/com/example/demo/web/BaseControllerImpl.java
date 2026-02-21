package com.example.demo.web;


import com.example.demo.model.BaseUser;
import com.example.demo.service.BaseUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BaseControllerImpl implements BaseController{
    private final BaseUserService service;

    public void login(String userName , String passwpord){
        
    }

    public List<BaseUser> allUsers(){
        return service.findAll();
    }

    public void registerUser(String userName, String password){
        service.registerUser(userName, password);
    }
}
