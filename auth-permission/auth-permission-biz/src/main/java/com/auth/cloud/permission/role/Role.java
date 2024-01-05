package com.auth.cloud.permission.role;


import com.auth.cloud.common.pojo.CommonResult;
import com.auth.cloud.i18n.enums.LanguageEnum;
import com.auth.cloud.i18n.utils.I18nUtil;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 黄灿民
 * @date 2024/01/03
 */
@RestController
public class Role {

    public CommonResult<String> getRole(String role){
//        return CommonResult.success("test");
        return CommonResult.success(I18nUtil.get("test",new String[]{role}, LanguageEnum.ENGLISH));
    }
}
