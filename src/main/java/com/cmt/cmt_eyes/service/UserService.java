package com.cmt.cmt_eyes.service;

import com.cmt.cmt_eyes.entity.TestEntity;
import com.cmt.cmt_eyes.entity.UserEntity;
import com.cmt.cmt_eyes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public UserEntity[] allUser(){
        return userRepository.allUser();
    }

    public UserEntity[] selUserList(UserEntity param) {
        return userRepository.selUserList(param);
    }
}
