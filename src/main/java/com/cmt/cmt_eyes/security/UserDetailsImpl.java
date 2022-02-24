package com.cmt.cmt_eyes.security;

import com.cmt.cmt_eyes.entity.UserEntity;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public UserDetailsImpl(UserEntity user) { //로컬로 로그인할때
        this.user = user;
    }
    //계정이 갖고있는 권한 목록
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //사용자의 권한을 콜렉션 형태로 반환 (클래스 자료형은 GrantedAuthority를 구현해야함)
        Set<GrantedAuthority> userSortId = new HashSet<>();
        userSortId.add(new SimpleGrantedAuthority("ROLE_"+user.getUserSortId()));
        return userSortId;
//        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+user.getUserSortId()));
    }

    @Override
    public String getPassword() { //사용자의 password를 반환
        return user.getUserPw();
    }

    @Override
    public String getUsername() { //사용자의 id를 반환(id는 unique한 값이여야함)
        return user.getUserId();
    }

    //계정이 만료되지 않았는지 리턴 (true:만료안됨)
    @Override
    public boolean isAccountNonExpired() { //계정 만료 여부 반환 (true = 만료되지 않음을 의미)
        return true;
    }

    //계정이 잠겨있는지 않았는지 리턴 (true:잠기지 않음)
    @Override
    public boolean isAccountNonLocked() { //계정 잠금 여부 반환 (true = 잠금되지 않음을 의미)
        return true;
    }

    //비밀번호가 만료되지 않았는지 리턴 (true:만료 안됨)
    @Override
    public boolean isCredentialsNonExpired() { //패스워드 만료 여부 반환 (true = 만료되지 않음을 의미)
        return true;
    }

    //계정이 활성화(사용가능)이지 리턴(true:활성화)

    @Override
    public boolean isEnabled() { //계정 사용 가능 여부 반환 (true = 사용 가능을 의미)
        return true;
    }
}
