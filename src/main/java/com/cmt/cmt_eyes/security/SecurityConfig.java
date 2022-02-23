package com.cmt.cmt_eyes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 시큐리티 필터 등록
// @EnableGlobalMethodSecurity(prePostEnabled = true)//특정 페이지에 특정 권한이 있는 유저만 접근을 허용할 경우 권한 및 인증을 미리 체크하겠다는 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override //인증 대상에서 제외
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/pic/**", "/css/**", "/js/**", "/img/**", "/error", "favicon.ico");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()// HTTP 요청 보안설정
                .antMatchers("/user/login").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/user/login")
                .usernameParameter("userId")
                .passwordParameter("userPw")
                .defaultSuccessUrl("/");
//                .permitAll();

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//로그아웃 경로
                .logoutSuccessUrl("/user/login")
                .invalidateHttpSession(true); //로그아웃 성공 시 세션 제거

        http.exceptionHandling()//권한이 없는 사용자가 접근했을 경우 이동할 경로
                .accessDeniedPage("/login");
    }

    @Override //사용자 인증
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
