package com.auth.cloud.authentication.pojo.vo;

import lombok.Data;

@Data
public class CaptchaVo {
    /**
     * 验证码
     */
    private String captcha;
    /**
     * 验证码Id
     */
    private String captchaId;
}
