package com.auth.cloud.permission.pojo.po;

import com.auth.cloud.common.pojo.Base;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 黄灿民
 * @date 2024/03/17
 */
@Data
@TableName("sys_language")
@Schema(description = "国际化资源")
public class I18nResourcePo extends Base {
    /**
     * i18n id
     */
    @TableId(type = IdType.AUTO)
    private Long i18nId;

    /**
     * 语言环境
     */
    private String locale;

    /**
     * 模块
     */
    private String i18nModule;

    /**
     * 键值
     */
    private String i18nKey;

    /**
     * 值
     */
    private String i18nValue;
}
