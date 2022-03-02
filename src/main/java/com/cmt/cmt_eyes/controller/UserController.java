package com.cmt.cmt_eyes.controller;


import com.cmt.cmt_eyes.dto.UserDto;
import com.cmt.cmt_eyes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired UserService userService;


    @GetMapping("/login")
    public void login(UserDto userDto){   }

    @GetMapping("/management")
    public void management(Model model){
//        UserDto[] list = userService.allUser();
//        model.addAttribute("users",list);
    }

    @GetMapping("/create")
    public void create(UserDto userDto, Model model){
        model.addAttribute("companys" , userService.selCompanyList());
    }

    @GetMapping("")
    public String userDetail(UserDto userDto, Model model){
        model.addAttribute("userDto",userService.selUser(userDto));
        return "user/detail";
    }

    @PostMapping("/create")
    public String userCreate(@Validated(UserDto.UserCreateValidationGroup.class) UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/user/create";
        }
        userService.createUser(userDto);
        return "user/management";
    }

    @PostMapping("/changePw")
    public String changePw(@Validated(UserDto.PwValidationGroup.class) UserDto userDto, BindingResult bindingResult, HttpServletRequest httpServletRequest){
        String pwChk = httpServletRequest.getParameter("pwChk");
        String oldPw = httpServletRequest.getParameter("oldPw");
        String pw = userDto.getUserPw();
        if(pwChk==null||oldPw==null||pw==null||pwChk==""||oldPw==""||pw==""){
            return "redirect:/?result=0";
        }
        if(!pwChk.equals(pw)){
            return "redirect:/?result=1";
        }
        if(!userService.chkOldPw(oldPw)){
            return "redirect:/?result=2";
        }
        if(bindingResult.hasErrors()){ //뭐가 틀렸는지
            return "user/changePw";
        }
        userService.updatePw(userDto);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/userList")
    public UserDto[] selUserList(UserDto param){
        return userService.selUserList(param);
    }

    @ResponseBody
    @GetMapping("/approval")
    public boolean approval(UserDto param){
        System.out.println("!!!");
        return userService.approval(param);
    }

    @ResponseBody
    @GetMapping("/resetPw")
    public String resetPw(UserDto param){
        return userService.resetPw(param);
    }

    @ResponseBody
    @PostMapping("/approval")
    public boolean approval2(UserDto param){
        return false;
    }
}
