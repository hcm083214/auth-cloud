package com.auth.cloud.permission.pojo.vo.reqvo.i18n;

import com.auth.cloud.common.pojo.Base;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class I18nSearchReqVo  {

    /**
     * 语言环境
     */
    private String locale;

    /**
     * 模块
     */
    private String i18nModule;

    /**
     * 键
     */
    private String i18nKey;


    /**
     * 页码
     */
    @NotNull(message = "current 未传")
    private Integer current;

    /**
     * 每页条数
     */
    @NotNull(message = "size 未传")
    private Integer size;
}
