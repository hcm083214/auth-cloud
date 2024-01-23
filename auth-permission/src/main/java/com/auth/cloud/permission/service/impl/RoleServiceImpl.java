package com.auth.cloud.permission.service.impl;

import com.auth.cloud.permission.mapper.RoleMapper;
import com.auth.cloud.permission.pojo.po.RolePo;
import com.auth.cloud.permission.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 黄灿民
 * @date 2024/01/21
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据角色id获取角色信息
     *
     * @param roleId
     * @return {@link RolePo}
     */
    @Override
    public RolePo getRoleById(Long roleId) {
        return roleMapper.selectById(roleId);
    }
}
