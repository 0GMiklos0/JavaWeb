package com.example.demo.repository;

import com.example.demo.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseUserRepository extends JpaRepository<BaseUser, Long>{
    Optional<BaseUser> findByUserName(String userName);
}
