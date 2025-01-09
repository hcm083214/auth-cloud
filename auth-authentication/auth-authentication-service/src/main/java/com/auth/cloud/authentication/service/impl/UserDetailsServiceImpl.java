package com.auth.cloud.authentication.service.impl;

import com.auth.cloud.authentication.mapper.UserMapper;
import com.auth.cloud.authentication.pojo.po.UserPo;
import com.auth.cloud.security.pojo.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<UserPo> query = new QueryWrapper<>();
        query.eq("username", username);
        UserPo userPo = userMapper.selectOne(query);
        if (userPo == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return new UserInfo<UserPo>() ;
    }
}
