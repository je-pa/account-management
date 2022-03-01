package com.cmt.cmt_eyes.controller;

import com.cmt.cmt_eyes.entity.PwReseted;
import com.cmt.cmt_eyes.dto.UserDto;
import com.cmt.cmt_eyes.security.AuthenticationInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class pageController {
    @Autowired AuthenticationInformation auth;

    @GetMapping("/")
    public String main(UserDto userDto){
        if(auth.getLoginUser().getPwReseted()== PwReseted.N){
            return "user/changePw";
        }
        return "main";
    }
}
