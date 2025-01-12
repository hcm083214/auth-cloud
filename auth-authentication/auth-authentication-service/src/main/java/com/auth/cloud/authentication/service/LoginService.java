package com.auth.cloud.authentication.service;

import com.auth.cloud.common.pojo.CommonResult;
import com.auth.cloud.security.pojo.UserInfo;

public interface LoginService {
    UserInfo loginByUsernameAndPassword(String username, String password);
}
