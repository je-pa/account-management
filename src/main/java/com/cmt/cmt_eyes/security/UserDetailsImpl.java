package com.cmt.cmt_eyes.security;

import com.cmt.cmt_eyes.entity.UserEntity;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {
    @Getter
    private UserEntity user;

    public UserDetailsImpl(UserEntity user) { //로컬로 로그인할때
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //사용자의 권한을 콜렉션 형태로 반환 (클래스 자료형은 GrantedAuthority를 구현해야함)
        Set<GrantedAuthority> userSortId = new HashSet<>();
//        userSortId.add(new SimpleGrantedAuthority(Integer.toString(user.getUserSortId())));
        return userSortId;
    }

    @Override
    public String getPassword() { //사용자의 password를 반환
        return null;//user.getUserPw();
    }

    @Override
    public String getUsername() { //사용자의 id를 반환(id는 unique한 값이여야함)
        return null;//user.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() { //계정 만료 여부 반환 (true = 만료되지 않음을 의미)
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //계정 잠금 여부 반환 (true = 잠금되지 않음을 의미)
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //패스워드 만료 여부 반환 (true = 만료되지 않음을 의미)
        return true;
    }

    @Override
    public boolean isEnabled() { //계정 사용 가능 여부 반환 (true = 사용 가능을 의미)
        return true;
    }
}
