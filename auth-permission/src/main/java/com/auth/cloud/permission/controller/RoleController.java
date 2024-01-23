package com.auth.cloud.permission.controller;


import com.auth.cloud.common.pojo.CommonResult;
import com.auth.cloud.i18n.enums.LanguageEnum;

import com.auth.cloud.i18n.core.I18n;
import com.auth.cloud.permission.convert.RoleConvert;
import com.auth.cloud.permission.pojo.po.RolePo;
import com.auth.cloud.permission.pojo.vo.respvo.RoleRespVo;
import com.auth.cloud.permission.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 黄灿民
 * @date 2024/01/03
 */
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {

    @Autowired
    private I18n i18n;

    @Autowired
    private RoleService roleService;

    public CommonResult<String> testI18n(String role) {
        return CommonResult.success(i18n.get("test", new String[]{role}, LanguageEnum.ENGLISH));
    }

    @GetMapping("role_id/{roleId}")
    public CommonResult<RoleRespVo> getRoleById(@PathVariable("roleId") Long roleId) {
        RolePo rolePo = roleService.getRoleById(roleId);
        log.info("rolePo: {}", rolePo);
        return CommonResult.success(RoleConvert.INSTANCE.poToVo(rolePo));
    }
}
