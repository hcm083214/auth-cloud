package com.auth.cloud.authentication.controller;

import com.auth.cloud.authentication.convert.UserInfoConvert;
import com.auth.cloud.authentication.pojo.vo.UserVo;
import com.auth.cloud.authentication.pojo.vo.reqvo.login.LoginUserReqVo;
import com.auth.cloud.authentication.pojo.vo.respvo.login.LoginUserRespVo;
import com.auth.cloud.authentication.service.CaptchaService;
import com.auth.cloud.authentication.service.LoginService;
import com.auth.cloud.common.pojo.CommonResult;
import com.auth.cloud.security.pojo.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 黄灿民
 * @date 2025/01/09
 */
@RestController
@Tag(name = "登录", description = "登录相关接口")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private CaptchaService captchaService;

    @Operation(summary = "登录接口", description = "根据用户名和账号登录")
    @PostMapping("/login")
    public CommonResult<LoginUserRespVo> login(@RequestBody LoginUserReqVo loginUserReqVo) {
        LoginUserRespVo loginUserRespVo = null;
        if (captchaService.checkCaptcha(loginUserReqVo.getCaptchaId())) {
            UserInfo userInfo = loginService.loginByUsernameAndPassword(loginUserReqVo.getUsername(), loginUserReqVo.getPassword());
            UserVo userVo = UserInfoConvert.userInfoToUserVo(userInfo);
            loginUserRespVo = new LoginUserRespVo();
            loginUserRespVo.setUserVo(userVo);
        }
        return CommonResult.success(loginUserRespVo);
    }
}
