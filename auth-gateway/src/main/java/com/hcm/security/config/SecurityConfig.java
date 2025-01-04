package com.hcm.security.config;


import com.hcm.security.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


/**
 * @author 黄灿民
 * @date 2024/12/21
 * 配置WebFlux的安全设置
 * 该类通过@EnableWebFluxSecurity注解启用WebFlux安全配置，并通过@Configuration注解声明这是一个配置类
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Autowired
    private AuthorizationManager authorizationManager;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private LogoutHandler logoutHandler;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

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

    /**
     * 配置SecurityWebFilterChain bean
     * 该方法用于定义和配置WebFlux的安全过滤链，包括访问控制、登录、登出以及异常处理等
     *
     * @param serverHttpSecurity 用于配置安全设置的ServerHttpSecurity对象
     * @return 配置好的SecurityWebFilterChain bean
     */
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity
                .authorizeExchange(authorizeExchangeSpec -> authorizeExchangeSpec
                        // 配置允许匿名访问的路径
                        .pathMatchers(allowPaths).permitAll()
                        // 其他所有请求都需要通过自定义的授权管理器进行访问控制
                        // .anyExchange().access(authorizationManager)
                        .anyExchange().authenticated()
                )
                // 启用HTTP Basic认证
                .httpBasic()
                .and()
                // 配置登录页面的路径
                .formLogin().loginPage("/user/login")
                // 处理登录成功
                .authenticationSuccessHandler(authenticationSuccessHandler)
                // 处理登录失败
                .authenticationFailureHandler(authenticationFailureHandler)
                // 配置未认证用户的入口点
                .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                // 处理访问 denied
                .accessDeniedHandler(accessDeniedHandler)
                // 禁用CSRF保护，以简化示例
                .and().csrf().disable()
                // 配置登出路径
                .logout().logoutUrl("/user/logout")
                // 处理登出逻辑
                .logoutHandler(logoutHandler)
                // 处理登出成功
                .logoutSuccessHandler(logoutSuccessHandler);
        return serverHttpSecurity.build();
    }

}

