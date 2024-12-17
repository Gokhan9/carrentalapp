package com.api.carrentalapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public abstract class WebSecurityConfigurerAdapter {

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return null;
    }

    public abstract void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception;

    public abstract void configure(HttpSecurity httpSecurity) throws Exception;

    public abstract SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception;
}
