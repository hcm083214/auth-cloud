package com.auth.cloud.security.config;

import com.auth.cloud.security.filter.TokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private TokenAuthenticationFilter tokenAuthenticationFilter;

    /**
     * 定义无需认证即可访问的路径
     */
    private final String[] allowPaths = {
            "/favicon.ico",
            "/login",
            "/logout",
    };

    /**
     * 配置认证过滤器链
     *
     * @param httpSecurity
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // 配置请求授权规则
        httpSecurity
                .authorizeRequests(authorizeRequests -> {
                    authorizeRequests
                            .antMatchers(allowPaths).permitAll() // 允许指定路径无需认证
                            .anyRequest().authenticated(); // 其他所有请求都需要认证
                })
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint) // 配置未认证时的处理入口
                .accessDeniedHandler(accessDeniedHandler) // 配置访问拒绝时的处理
                .and()
                .csrf().disable() // 禁用CSRF保护，适用于无状态认证
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)// 配置会话管理策略为无状态
                .and()
                // 自定义登录页面
                .formLogin().loginPage("/login") .permitAll()
                // 注销功能对所有人开放
                .and().logout().permitAll();

        // 在UsernamePasswordAuthenticationFilter之前添加自定义的Token认证过滤器
        httpSecurity.addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build(); // 构建并返回配置的过滤器链
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}
