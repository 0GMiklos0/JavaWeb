package com.example.demo.web;

import com.example.demo.model.BaseUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public interface UserController {
    @GetMapping("/{username}")
    BaseUser getMyData(@PathVariable String username);

    @PutMapping("/{username}")
    void changeMyData(BaseUser currentUser,BaseUser newUser);
}
