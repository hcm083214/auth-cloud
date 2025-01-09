package com.auth.cloud.authentication.controller;

import com.auth.cloud.authentication.pojo.vo.reqvo.login.LoginUserReqVo;
import com.auth.cloud.authentication.pojo.vo.respvo.login.LoginUserRespVo;
import com.auth.cloud.common.pojo.CommonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 黄灿民
 * @date 2025/01/09
 */
@RestController
public class LoginController {

    public CommonResult<LoginUserRespVo> login(@RequestBody LoginUserReqVo loginUserReqVo){

        return CommonResult.success(new LoginUserRespVo());
    }
}
