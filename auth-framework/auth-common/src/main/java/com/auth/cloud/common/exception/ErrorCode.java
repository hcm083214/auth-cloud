package com.auth.cloud.common.exception;


import com.auth.cloud.i18n.core.I18nUtil;
import lombok.Data;

/**
 * @author 黄灿民
 * @date 2024/01/03
 */
@Data
public class ErrorCode {
    public Integer code;
    public String message;
    public ErrorCode(Integer code,String message) {
        this.code = code;
        this.message = I18nUtil.get(message);
    }
}
