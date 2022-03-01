package com.cmt.cmt_eyes.security;

import com.cmt.cmt_eyes.dto.UserDto;
import com.cmt.cmt_eyes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return new UserDetailsImpl(loadUserByUsernameProvider(userId));
    }
    public UserDto loadUserByUsernameProvider(String userId)throws UsernameNotFoundException{
        UserDto param = new UserDto();
        param.setUserId(userId);
        UserDto user = userRepository.loginUser(param);
        return user;
    }
}
