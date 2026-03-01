package com.example.demo.web;

import com.example.demo.model.BaseUser;
import com.example.demo.service.BaseUserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController{
    private final BaseUserService service;

    @Override
    public BaseUser getMyData(String username) {
        return service.findOne(username);
    }

    @Override
    public void changeMyData(BaseUser currentUser, BaseUser newUser) {
        service.changeMyData(currentUser, newUser);
    }

    @Override
    public String getMe(@NonNull Principal principal) {
        return principal.getName();
    }
}
