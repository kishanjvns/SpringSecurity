package com.tech.kj.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * This `DefaultSecurityConfig` has implemented the default behaviour of spring http basic
 */
@Configuration
public class DefaultSecurityConfigV2 {

    @Bean
    public SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic(Customizer.withDefaults());
        var user = User.withUsername("kishan")
                .password("password")
                .authorities("read")
                .build();
        UserDetailsService userDetailsService = new InMemoryUserDetailsManager(user);
        httpSecurity.userDetailsService(userDetailsService);
        httpSecurity.authorizeHttpRequests(c-> c.anyRequest().authenticated());
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
