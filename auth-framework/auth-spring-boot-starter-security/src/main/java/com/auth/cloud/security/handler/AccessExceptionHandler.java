package com.auth.cloud.security.handler;

import com.auth.cloud.common.enums.GlobalCodeConstants;
import com.auth.cloud.common.handler.ResponseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AccessExceptionHandler implements AccessDeniedHandler {
    /**
     * 访问拒绝处理
     * @param request
     * @param response
     * @param accessDeniedException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) {
        // 记录访问拒绝事件
        log.warn("Access denied for request: {}, IP: {}",
                request.getRequestURI(), request.getRemoteAddr(), accessDeniedException);

        try {
            // 设置HTTP状态码为403 Forbidden
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);

            // 处理响应内容
            ResponseHandler.handler(response,
                    GlobalCodeConstants.FORBIDDEN.getCode(),
                    GlobalCodeConstants.FORBIDDEN.getMessage());
        } catch (Exception e) {
            // 记录处理响应时发生的异常
            log.error("Error handling access denied response", e);
            // 确保即使发生异常也返回403状态码
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
