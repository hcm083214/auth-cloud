package com.auth.cloud.authentication.convert;

import com.auth.cloud.authentication.pojo.po.UserPo;
import com.auth.cloud.authentication.pojo.vo.UserVo;
import com.auth.cloud.authentication.pojo.vo.respvo.login.LoginUserRespVo;
import com.auth.cloud.security.pojo.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserVo poToVo(User user);

    User poToUser(UserPo userPo);

    LoginUserRespVo voToLoginUserRespVo(UserVo userVo);
}
