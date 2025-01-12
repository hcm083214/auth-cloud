package com.auth.cloud.authentication.controller;

import com.auth.cloud.authentication.pojo.vo.CaptchaVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 黄灿民
 * @date 2025/01/09
 */
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @GetMapping("/text")
    public CaptchaVo getCaptcha() {
        CaptchaVo captchaVo = new CaptchaVo();
        captchaVo.setCaptchaId("1111");
        captchaVo.setCaptcha("captcha");
        return captchaVo;
    }
}
