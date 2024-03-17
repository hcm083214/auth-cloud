package com.auth.cloud.permission.pojo.vo.respvo;

import com.auth.cloud.common.pojo.Base;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 黄灿民
 * @date 2024/01/21
 */
@Data
@Schema(description = "角色响应对象")
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

    /**
     * 排序
     */
    private Integer orderNum;
}
