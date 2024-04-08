package com.auth.cloud.permission.pojo.vo.reqvo.i18n;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 黄灿民
 * @date 2024/03/26
 */
@Data
public class I18nEditReqVo {

    /**
     * i18n id
     */
    @NotNull(message = "i18nId 未传")
    private Long i18nId;

    /**
     * 语言环境
     */
    @NotBlank(message = "locale 未传")
    private String locale;

    /**
     * 模块
     */
    @NotBlank(message = "i18nModule 未传")
    private String i18nModule;

    /**
     * 键
     */
    @NotBlank(message = "i18nKey 未传")
    private String i18nKey;

    /**
     * 值
     */
    @NotBlank(message = "i18nValue 未传")
    private String i18nValue;
}
