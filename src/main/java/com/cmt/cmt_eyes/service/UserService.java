package com.cmt.cmt_eyes.service;

import com.cmt.cmt_eyes.dto.PageDto;
import com.cmt.cmt_eyes.dto.UserDto;
import com.cmt.cmt_eyes.PwReseted;
import com.cmt.cmt_eyes.dto.UserListPagingDto;
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

    public UserDto[] allUser(){
        return userRepository.allUser();
    }

    public int createUser(UserDto userDto){
        userDto.setApplicant(authenticationInformation.getLoginUser().getUserId());
        if(userDto.getUserSortId()==2){
            userDto.setCompany(userDto.getUserName());
        }
        return userRepository.createUser(userDto);
    }

    public UserDto selUser(UserDto param){
        return userRepository.selUser(param);
    }

    public UserDto[] selUserList(UserListPagingDto param) {
        int loginSortId = authenticationInformation.getLoginUserSortId();
        if(loginSortId == 2){
            param.setCompany(authenticationInformation.getLoginUser().getUserName());
            param.setUserSortId(3);
            param.setLoginUserSort("company");
        }else if(loginSortId == 3){
            param.setCompany(authenticationInformation.getLoginUser().getCompany());
            param.setLoginUserSort("customer");
        }else if(loginSortId == 1){
            param.setLoginUserSort("admin");
        }else if(loginSortId == 4){
            param.setLoginUserSort("employee");
        }
        return userRepository.selUserList(param);
    }

    public PageDto countPage(UserListPagingDto param){
        PageDto pageDto = userRepository.countPage(param);
        if(pageDto.getCount()==0){
            pageDto.setCount(1);
        }
        return pageDto;
    }

    public boolean approval(UserDto param) {
        if(authenticationInformation.getLoginUserSortId()!=1){
            return false;
        }
        if(userRepository.approvalUser(param)==1){
            System.out.println("re1");
            return true;
        }
        return false;
    }

    public String resetPw(UserDto param) {
        if(authenticationInformation.getLoginUserSortId()!=1){
            return "권한없음";
        }
        String randomNum = mySecurityUtils.getRandomDigit(5);
        param.setUserPw(passwordEncoder.encode(randomNum));
        param.setPwReseted(PwReseted.N);
        if(userRepository.updatePw(param)==1){
            return randomNum;
        }
        return "비번초기화 실패";
    }

    public void updatePw(UserDto userDto){
        UserDto loginUser = authenticationInformation.getLoginUser();
        userDto.setPwReseted(PwReseted.Y);
        String encoded = passwordEncoder.encode(userDto.getUserPw());
        userDto.setUserPw(encoded);
        userDto.setUserId(loginUser.getUserId());
        if(userRepository.updatePw(userDto)==1){
            loginUser.setUserPw(encoded);
            loginUser.setPwReseted(PwReseted.Y);
        }
    }

    public boolean chkOldPw(String oldPw){
        return passwordEncoder.matches(oldPw,authenticationInformation.getLoginUser().getUserPw());
    }

    public UserDto[] selCompanyList() {
        return userRepository.selCompanyList();
    }
}
