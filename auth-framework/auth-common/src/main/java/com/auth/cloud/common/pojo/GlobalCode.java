package com.auth.cloud.common.pojo;


import com.auth.cloud.i18n.core.I18nUtil;

/**
 * @author 黄灿民
 * @date 2024/01/03
 */
public class GlobalCode {
    public Integer code;
    public String message;

    public String getMessage() {
        return I18nUtil.get(message);
    }

    public GlobalCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }
}
