package com.auth.cloud.common.exception;

import com.auth.cloud.common.exception.enums.GlobalCodeConstants;

/**
 * @author 黄灿民
 * @date 2024/03/24
 */
public class BadRequestException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 错误提示
     */
    private String message;

    /**
     * 错误提示
     */
    private Integer code;

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        this.message = message;
        this.code = GlobalCodeConstants.BAD_REQUEST.getCode();
    }

    public BadRequestException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
