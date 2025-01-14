package com.auth.cloud.security.config;

import com.auth.cloud.security.filter.TokenAuthenticationFilter;
import com.auth.cloud.security.handler.AccessExceptionHandler;
import com.auth.cloud.security.handler.AuthExceptionHandler;
import com.auth.cloud.security.service.DefaultUserDetailsService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author 黄灿民
 * @date 2025/01/05
 */
@AutoConfiguration
@AutoConfigureOrder(-1)
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    /**
     * 认证异常处理器
     * @return AuthenticationEntryPoint
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthExceptionHandler();
    }

    /**
     * 授权异常处理器
     * @return AccessDeniedHandler
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new AccessExceptionHandler();
    }

    /**
     * token认证过滤器
     * @return TokenAuthenticationFilter
     */
    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }

    @Bean
    @ConditionalOnMissingBean
    public UserDetailsService defaultUserDetailsService() {
        return new DefaultUserDetailsService();
    }
}
