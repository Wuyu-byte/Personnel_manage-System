//package com.xlk.config;
//
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    //链式编程
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        super.configure(http);
//        http.authorizeRequests().antMatchers("/").permitAll();
//    }
//}
