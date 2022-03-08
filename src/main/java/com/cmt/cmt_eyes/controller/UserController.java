package com.cmt.cmt_eyes.controller;


import com.cmt.cmt_eyes.dto.UserDto;
import com.cmt.cmt_eyes.dto.UserListPagingDto;
import com.cmt.cmt_eyes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired UserService userService;

    @GetMapping("/login")
    public void login(UserDto userDto){   }

    @GetMapping("/management")
    public void management(UserListPagingDto param, Model model){
        if(param.getPage()==0){
            param.setPage(1);
        }
        param.setLimit(3);
        model.addAttribute("users",userService.selUserList(param));
        model.addAttribute("page",userService.countPage(param));
        model.addAttribute("companys" , userService.selCompanyList());
    }

    @GetMapping("/myPage")
    public String myPage(){ return "user/my_page"; }

    @GetMapping("/changePw")
    public String changePw(UserDto userDto){ return "user/changePw";}

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
    public String userCreate(Model model, @Validated(UserDto.UserCreateValidationGroup.class) UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("companys" , userService.selCompanyList());
            return "user/create";
        }
        if(userService.selUser(userDto)!=null){
            model.addAttribute("userIdError" , "사용할 수 없는 아이디입니다.");
            return "user/create";
        }
        userService.createUser(userDto);
        return "redirect:management";
    }

    @PutMapping("/changePw")
    public String changePw(@Validated(UserDto.PwValidationGroup.class) UserDto userDto, BindingResult bindingResult, HttpServletRequest httpServletRequest){
        String pwChk = httpServletRequest.getParameter("pwChk");
        String oldPw = httpServletRequest.getParameter("oldPw");
        String pw = userDto.getUserPw();
        if(pwChk==null||oldPw==null||pw==null||pwChk==""||oldPw==""||pw==""){
            return "redirect:/user/changePw?result=0";
        }
        if(!pwChk.equals(pw)){
            return "redirect:/user/changePw?result=1";
        }
        if(!userService.chkOldPw(oldPw)){
            return "redirect:/user/changePw?result=2";
        }
        if(bindingResult.hasErrors()){ //뭐가 틀렸는지
            return "user/changePw";
        }
        userService.updatePw(userDto);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/userList")
    public UserDto[] selUserList(UserListPagingDto param){
        return userService.selUserList(param);
    }

    @ResponseBody
    @PutMapping("/approval")
    public boolean approval(@RequestBody UserDto param){
        System.out.println("!!!");
        return userService.approval(param);
    }

    @ResponseBody
    @PutMapping("/resetPw")
    public String resetPw(UserDto param){
        return userService.resetPw(param);
    }
}
