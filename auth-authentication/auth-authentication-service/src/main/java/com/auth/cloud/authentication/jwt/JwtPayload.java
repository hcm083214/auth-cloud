package com.auth.cloud.authentication.jwt;

import lombok.Data;

/**
 * @author pc
 * @description 用于封装JWT中存储的信息
 */
@Data
public class JwtPayload {

    /**
     * sub 主题
     */
    private String sub;

    /**
     * iat 签发时间
     */
    private Long iat;

    /**
     * exp 过期时间
     */
    private Long exp;

    /**
     * jti JWT ID
     */
    private String jti;

}
