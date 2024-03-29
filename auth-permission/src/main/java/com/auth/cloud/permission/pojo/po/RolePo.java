package com.auth.cloud.permission.pojo.po;

import com.auth.cloud.common.pojo.Base;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 黄灿民
 * @date 2024/01/21
 */
@Data
@TableName("sys_role")
@Schema(description = "角色对象")
public class RolePo extends Base {

    /**
     * 角色ID，必须指定 tableId ，要不然和 id 相关的操作会报错
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

    /**
     * 排序
     */
    private Integer orderNum;
}
