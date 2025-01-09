package com.auth.cloud.authentication.pojo.vo.reqvo.login;

import lombok.Data;

/**
 * @author 黄灿民
 * @date 2025/01/09
 */
@Data
public class LoginUserReqVo {

    private String username;

    private String password;

    private String code;
}
