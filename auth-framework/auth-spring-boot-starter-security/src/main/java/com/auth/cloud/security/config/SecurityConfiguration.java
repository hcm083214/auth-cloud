package com.auth.cloud.security.config;

import com.auth.cloud.security.handler.AuthExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @author 黄灿民
 * @date 2025/01/05
 */
@AutoConfiguration
@AutoConfigureOrder(-1)
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthExceptionHandler();
    }

}
