package com.auth.cloud.authentication.service.impl;

import com.auth.cloud.authentication.service.CaptchaService;
import org.springframework.stereotype.Service;

@Service
public class CaptchaServiceImpl implements CaptchaService {
    @Override
    public String getCaptcha() {
        return null;
    }

    @Override
    public boolean checkCaptcha(String captchaId) {
        return true;
    }

    @Override
    public void clearCaptcha(Long captchaId) {

    }
}
