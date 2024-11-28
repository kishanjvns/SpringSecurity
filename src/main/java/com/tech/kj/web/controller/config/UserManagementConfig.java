package com.tech.kj.web.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserManagementConfig {
    private static final String loadUserByNameQuery="select username,password,is_expired from App_User where username = ?";
    private static final String loadAuthoritiesByUserNameQuery= "select username,authority from authorities where username= ?";

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        var userDetailsService =  new JdbcUserDetailsManager(dataSource);
        userDetailsService.setUsersByUsernameQuery(loadUserByNameQuery);
        userDetailsService.setAuthoritiesByUsernameQuery(loadAuthoritiesByUserNameQuery);
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  NoOpPasswordEncoder.getInstance();
    }
}
