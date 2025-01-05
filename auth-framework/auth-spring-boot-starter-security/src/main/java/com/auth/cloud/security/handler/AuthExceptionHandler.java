package com.auth.cloud.security.handler;

import com.auth.cloud.common.exception.enums.GlobalCodeConstants;
import com.auth.cloud.common.handler.ResponseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄灿民
 * @date 2025/01/05
 */
@Slf4j
@Component
public class AuthExceptionHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        if (authException != null) {
            log.error("AuthExceptionHandler ---> commence,认证失败: {}", authException.getClass().getName());
        } else {
            log.error("AuthExceptionHandler ---> commence,认证失败: authException is null");
        }
        // 根据不同的异常类型返回不同的响应
        if (authException instanceof BadCredentialsException) {
            ResponseHandler.handler(response,
                    GlobalCodeConstants.BAD_CREDENTIALS.getCode(),
                    GlobalCodeConstants.BAD_CREDENTIALS.getMessage());
        } else if (authException instanceof LockedException) {
            ResponseHandler.handler(response,
                    GlobalCodeConstants.LOCKED.getCode(),
                    GlobalCodeConstants.LOCKED.getMessage());
        } else {
            ResponseHandler.handler(response,
                    GlobalCodeConstants.UNAUTHORIZED.getCode(),
                    GlobalCodeConstants.UNAUTHORIZED.getMessage());
        }
    }
}
