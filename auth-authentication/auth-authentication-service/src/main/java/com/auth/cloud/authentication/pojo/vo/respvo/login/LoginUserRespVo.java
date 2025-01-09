package com.auth.cloud.authentication.pojo.vo.respvo.login;

import com.auth.cloud.authentication.pojo.vo.UserVo;
import lombok.Data;

/**
 * @author 黄灿民
 * @date 2025/01/09
 */
@Data
public class LoginUserRespVo {
    private String token;
    private UserVo userVo;
}
