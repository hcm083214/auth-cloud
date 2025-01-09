package com.auth.cloud.authentication.service;

/**
 * @author 黄灿民
 * @date 2025/01/09
 */
public interface CaptchaService {
    String getCaptcha();
    boolean checkCaptcha(Long captchaId);
    void clearCaptcha();
    void clearCaptcha(Long captchaId);
}
