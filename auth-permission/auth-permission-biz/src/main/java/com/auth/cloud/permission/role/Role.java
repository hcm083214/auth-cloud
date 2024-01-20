package com.auth.cloud.permission.role;


import com.auth.cloud.common.pojo.CommonResult;
import com.auth.cloud.i18n.enums.LanguageEnum;

import com.auth.cloud.i18n.utils.I18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 黄灿民
 * @date 2024/01/03
 */
@RestController
public class Role {

    @Autowired
    private I18n i18N;

    public CommonResult<String> getRole(String role){
//        return CommonResult.success("test");
        return CommonResult.success(i18N.get("test",new String[]{role}, LanguageEnum.ENGLISH));
    }
}
