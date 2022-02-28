package com.cmt.cmt_eyes.controller;


import com.cmt.cmt_eyes.entity.UserEntity;
import com.cmt.cmt_eyes.security.MySecurityUtils;
import com.cmt.cmt_eyes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired UserService userService;


    @GetMapping("/login")
    public void login(UserEntity userEntity){   }

    @GetMapping("/management")
    public void management(Model model){
        UserEntity[] list = userService.allUser();
        model.addAttribute("users",list);
    }

    @GetMapping("/create")
    public void create(UserEntity userEntity, Model model){
        model.addAttribute("companys" , userService.selCompanyList());
    }

    @GetMapping("")
    public String userDetail(UserEntity userEntity, Model model){
        model.addAttribute("userEntity",userService.selUser(userEntity));
        return "user/detail";
    }

    @ResponseBody
    @GetMapping("/userList")
    public UserEntity[] selUserList(UserEntity param){
        return userService.selUserList(param);
    }

    @ResponseBody
    @GetMapping("/approval")
    public boolean approval(UserEntity param){
        System.out.println("!!!");
        return userService.approval(param);
    }

    @ResponseBody
    @GetMapping("/resetPw")
    public String resetPw(UserEntity param){
        return userService.resetPw(param);
    }
}
