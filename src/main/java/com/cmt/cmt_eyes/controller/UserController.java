package com.cmt.cmt_eyes.controller;

import com.cmt.cmt_eyes.TestService;
import com.cmt.cmt_eyes.entity.TestEntity;
import com.cmt.cmt_eyes.entity.UserEntity;
import com.cmt.cmt_eyes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired UserService userService;
    @Autowired PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public void login(UserEntity userEntity){
        System.out.println(passwordEncoder.encode("1"));
    }
    @GetMapping("/management")
    public void management(Model model){
        UserEntity[] list = userService.allUser();
        model.addAttribute("users",list);
    }
    @ResponseBody
    @GetMapping("/userList")
    public UserEntity[] selUserList(UserEntity param){
        return userService.selUserList(param);
    }
}
