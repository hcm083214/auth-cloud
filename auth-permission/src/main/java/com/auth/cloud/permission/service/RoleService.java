package com.auth.cloud.permission.service;

import com.auth.cloud.permission.pojo.po.RolePo;
import org.springframework.stereotype.Service;

/**
 * @author 黄灿民
 * @date 2024/01/21
 */
public interface RoleService {

    /**
     * 根据角色id获取角色信息
     *
     * @param roleId
     * @return {@link RolePo}
     */
    RolePo getRoleById(Long roleId);
}
