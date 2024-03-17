package com.auth.cloud.common.pojo;

import com.auth.cloud.common.exception.enums.GlobalCodeConstants;
import com.auth.cloud.i18n.core.I18nUtil;
import lombok.Data;

/**
 * @author 黄灿民
 * @date 2023/11/27
 */
@Data
public class CommonResult<T> {
    /**
     * 状态码
     */
    private Integer code;


    /**
     * 状态信息
     */
    private String msg;


    /**
     * 返回对象
     */
    private T data;

    public static <T> CommonResult<T> success(T data){
        CommonResult<T> result = new CommonResult<>();
        result.data = data;
        result.code = GlobalCodeConstants.SUCCESS.getCode();
        result.msg = I18nUtil.get("success");
        return result;
    }

    public static <T> CommonResult<T> error(Integer code, String msg){
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.msg = msg;
        return result;
    }
}
