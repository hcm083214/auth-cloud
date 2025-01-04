package com.auth.cloud.permission.controller;

import com.auth.cloud.common.pojo.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthLoginController {

    @PostMapping("/login")
    public CommonResult<String> login() {

        return CommonResult.success("登录成功");
    }
}
