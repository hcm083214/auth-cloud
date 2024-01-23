package com.auth.cloud.permission.pojo.po;

import com.auth.cloud.common.pojo.Base;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 黄灿民
 * @date 2024/01/21
 */
@Data
@TableName("sys_role")
public class RolePo extends Base {

    /**
     * 角色ID
     */
    @TableId(type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleNameCn;

    /**
     * 角色中文描述
     */
    private String roleDescriptionCn;

    /**
     * 角色英文名称
     */
    private String roleNameEn;

    /**
     * 角色英文描述
     */
    private String roleDescriptionEn;
}
