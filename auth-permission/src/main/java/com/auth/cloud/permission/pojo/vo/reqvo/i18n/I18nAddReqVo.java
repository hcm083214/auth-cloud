package com.auth.cloud.permission.pojo.vo.reqvo.i18n;

import com.auth.cloud.common.pojo.Base;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 黄灿民
 * @date 2024/03/24
 */
@Data
public class I18nAddReqVo  {

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
