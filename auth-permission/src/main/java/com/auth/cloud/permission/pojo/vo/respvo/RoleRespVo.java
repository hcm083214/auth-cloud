package com.auth.cloud.permission.pojo.vo.respvo;

import com.auth.cloud.common.pojo.Base;
import lombok.Data;

/**
 * @author 黄灿民
 * @date 2024/01/21
 */
@Data
public class RoleRespVo extends Base {
    /**
     * 角色ID
     */
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
