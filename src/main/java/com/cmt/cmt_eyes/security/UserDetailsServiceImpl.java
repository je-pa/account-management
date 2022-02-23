package com.cmt.cmt_eyes.security;

import com.cmt.cmt_eyes.entity.UserEntity;
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
    public UserEntity loadUserByUsernameProvider(String userId)throws UsernameNotFoundException{
        UserEntity param = new UserEntity();
        param.setUserId(userId);
        UserEntity user = userRepository.selUser(param);
        return user;
    }
}
