package com.auth.cloud.authentication.service.impl;

import com.auth.cloud.authentication.service.LoginService;
import com.auth.cloud.common.enums.GlobalCodeConstants;
import com.auth.cloud.common.exception.BadRequestException;
import com.auth.cloud.security.context.AuthenticationContextHolder;
import com.auth.cloud.security.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserInfo loginByUsernameAndPassword(String username, String password) {
        Authentication authentication;
        try {
            // 创建认证令牌
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            username,
                            password
                    )
            );

            // 设置认证信息到安全上下文中
            // 将返回的Authentication存到上下文中。
            AuthenticationContextHolder.setSecurityContext(authentication);
            // 放入到自定义的上下文的作用是为了限制同一账号多次登陆
            AuthenticationContextHolder.setContext(authentication);

        } catch (Exception e) {
            log.error("UserLoginService ---> login:{}", e.getMessage());
            if (e instanceof BadCredentialsException) {
                throw new BadRequestException(GlobalCodeConstants.UNAUTHORIZED.getMessage(),
                        GlobalCodeConstants.UNAUTHORIZED.getCode());
            } else {
                throw new BadRequestException(e.getMessage());
            }
        } finally {
            AuthenticationContextHolder.removeContext();
        }
        return (UserInfo) authentication.getPrincipal();
    }
}
