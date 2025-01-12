package com.auth.cloud.authentication.service;

/**
 * @author 黄灿民
 * @date 2025/01/09
 */
public interface CaptchaService {
    String getCaptcha();
    boolean checkCaptcha(String captchaId);
    void clearCaptcha(Long captchaId);
}
