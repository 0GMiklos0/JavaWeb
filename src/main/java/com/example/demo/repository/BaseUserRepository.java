package com.example.demo.repository;

import com.example.demo.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseUserRepository extends JpaRepository<BaseUser, String>{
}
