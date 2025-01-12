package com.auth.cloud.authentication.service.impl;

import com.auth.cloud.authentication.convert.UserConvert;
import com.auth.cloud.authentication.mapper.UserMapper;
import com.auth.cloud.authentication.pojo.po.UserPo;
import com.auth.cloud.security.pojo.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


/**
 * @author 黄灿民
 * @date 2025/01/11
 * @Description 用户详情服务实现类，提供給 spring security 使用
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<UserPo> query = new QueryWrapper<>();
        query.eq("user_name", username);
        UserPo userPo = userMapper.selectOne(query);
        if (userPo == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return new UserInfo(UserConvert.INSTANCE.poToUser(userPo),new ArrayList<>() ) ;
    }
}
