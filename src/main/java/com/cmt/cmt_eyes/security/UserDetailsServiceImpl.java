package com.cmt.cmt_eyes.security;

import com.cmt.cmt_eyes.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
        return new UserDetailsImpl(loadUserByUsernameProvider(user_id));
    }
    public UserEntity loadUserByUsernameProvider(String user_id)throws UsernameNotFoundException{

        return null;
    }
}
