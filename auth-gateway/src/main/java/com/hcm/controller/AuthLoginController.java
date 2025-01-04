package com.hcm.controller;

import com.auth.cloud.common.pojo.CommonResult;
import com.hcm.api.AuthLoginApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@RestController
public class AuthLoginController {

    @Autowired
    private  AuthLoginApi authLoginApi;

    @PostMapping("/login")
    public Mono<CommonResult<String>> login() {
        return authLoginApi.login();
    }
}
