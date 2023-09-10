package com.example.employeeapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails pavan = User.builder()
                .username("pavan")
                .password("{noop}1234")
                .roles("EMPLOYEE")
                .build();

        UserDetails saranga = User.builder()
                .username("saranga")
                .password("{noop}1234")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails suranga = User.builder()
                .username("suranga")
                .password("{noop}1234")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(pavan,saranga,suranga);
    }
}