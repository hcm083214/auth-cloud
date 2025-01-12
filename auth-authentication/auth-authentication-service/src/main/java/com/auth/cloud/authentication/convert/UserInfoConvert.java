package com.auth.cloud.authentication.convert;

import com.auth.cloud.authentication.pojo.po.UserPo;
import com.auth.cloud.authentication.pojo.vo.UserVo;
import com.auth.cloud.security.pojo.User;
import com.auth.cloud.security.pojo.UserInfo;
import org.mapstruct.factory.Mappers;

public class UserInfoConvert {

   public static UserVo userInfoToUserVo(UserInfo userInfo){
        if (userInfo == null || userInfo.getUser() == null){
            return new UserVo();
        }else{
            User  userPo = (User) userInfo.getUser();
            return UserConvert.INSTANCE.poToVo(userPo);
        }
    }
}
