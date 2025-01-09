package com.auth.cloud.authentication.mapper;

import com.auth.cloud.authentication.pojo.po.UserPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserPo> {
}
