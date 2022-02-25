package com.cmt.cmt_eyes.service;

import com.cmt.cmt_eyes.entity.UserEntity;
import com.cmt.cmt_eyes.repository.UserRepository;
import com.cmt.cmt_eyes.security.AuthenticationInformation;
import com.cmt.cmt_eyes.security.MySecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;
    @Autowired private AuthenticationInformation authenticationInformation;
    @Autowired MySecurityUtils mySecurityUtils;
    @Autowired PasswordEncoder passwordEncoder;

    public UserEntity[] allUser(){
        return userRepository.allUser();
    }

    public UserEntity[] selUserList(UserEntity param) {
        return userRepository.selUserList(param);
    }

    public boolean approval(UserEntity param) {
        if(authenticationInformation.getLoginUserSortId()!=1){
            return false;
        }
        if(userRepository.approvalUser(param)==1){
            System.out.println("re1");
            return true;
        }
        return false;
    }

    public String resetPw(UserEntity param) {
        if(authenticationInformation.getLoginUserSortId()!=1){
            return "권한없음";
        }
        String randomNum = mySecurityUtils.getRandomDigit(5);
        param.setUserPw(passwordEncoder.encode(randomNum));
        if(userRepository.updatePw(param)==1){
            return randomNum;
        }
        return "비번초기화 실패";
    }
}
