package com.cmt.cmt_eyes.security;

import com.cmt.cmt_eyes.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationInformation {
    public UserEntity getLoginUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl)auth.getPrincipal();
        return userDetails.getUser();
    }

    public int getLoginUserSortId(){
        return getLoginUser().getUserSortId();
    }
}
