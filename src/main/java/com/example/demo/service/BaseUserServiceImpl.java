package com.example.demo.service;

import com.example.demo.model.BaseUser;
import com.example.demo.repository.BaseUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class BaseUserServiceImpl implements BaseUserService{
    private final BaseUserRepository repo;
    public void registerUser(String userName, String password){
        repo.save(
                BaseUser.builder()
                        .userName(userName)
                        .password(password)
                        .build()
        );
    }

    public List<BaseUser> findAll(){
        return repo.findAll()
                .stream()
                .toList();
    }

    public BaseUser findOne(String userName){
        return repo.findByUserName(userName).orElseThrow();
    }

    @Override
    public void changeMyData(BaseUser currentUser, BaseUser newUser) {
        BaseUser changed = repo.findByUserName(currentUser.getUserName()).orElseThrow();
        changed.setUserName(newUser.getUserName());
        changed.setPassword(newUser.getPassword());
    }
}
