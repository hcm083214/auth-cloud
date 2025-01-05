package com.auth.cloud.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author 黄灿民
 * @date 2025/01/05
 */
@EnableWebSecurity
@AutoConfiguration
@AutoConfigureOrder(-1)
public class SecurityAutoConfiguration {

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    /**
     * 定义无需认证即可访问的路径
     */
    private final String[] allowPaths = {
            "/favicon.ico",
            "/login",
            "/logout",
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests(authorizeRequests -> {
                    authorizeRequests
                            .antMatchers(allowPaths).permitAll()
                            .anyRequest().authenticated();
                })
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        return httpSecurity.build();
    }
}
