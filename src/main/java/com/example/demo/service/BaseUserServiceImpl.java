package com.example.demo.service;

import com.example.demo.model.BaseUser;
import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import com.example.demo.repository.BaseUserRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.Collection;
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
        BaseUser changed = repo.findByUserName(currentUser.getUsername()).orElseThrow();
        changed.setUserName(newUser.getUsername());
        changed.setPassword(newUser.getPassword());
    }

    public LoginResponse login(LoginRequest credentials){
        BaseUser loggedUser = repo.findByUserName(credentials.getUserName()).orElseThrow();

        return LoginResponse.builder()
                .userName(loggedUser.getUsername())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repo.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
