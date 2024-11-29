package com.tech.kj.web.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class HttpBasicConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(c-> c.requestMatchers("/h2-console/").permitAll().anyRequest().authenticated()
              );
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder builder){
        return builder.getOrBuild();
    }

}
