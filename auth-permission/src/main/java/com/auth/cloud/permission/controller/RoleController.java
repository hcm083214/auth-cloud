package com.auth.cloud.permission.controller;


import com.auth.cloud.common.pojo.CommonResult;
import com.auth.cloud.i18n.enums.LanguageEnum;

import com.auth.cloud.i18n.core.I18n;
import com.auth.cloud.permission.convert.RoleConvert;
import com.auth.cloud.permission.pojo.po.RolePo;
import com.auth.cloud.permission.pojo.vo.respvo.RoleRespVo;
import com.auth.cloud.permission.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 黄灿民
 * @date 2024/01/03
 */
@RestController
@RequestMapping("/role")
@Slf4j
@Tag(name = "权限管理后台 - 角色",description = "角色信息接口")
public class RoleController {

    @Autowired
    private I18n i18n;

    @Autowired
    private RoleService roleService;

    @GetMapping
    @Operation(summary = "测试接口")
    public CommonResult<String> testI18n(String role, HttpServletRequest request,@RequestHeader Map<String, String> headers) {
        request.getParameterMap().forEach((key,value)->{
            log.info("request,{},{}",key,value);
        });
        headers.forEach((key,value)->{
            log.info("headers,{},{}",key,value);
        });
        return CommonResult.success(i18n.get("test", new String[]{role}, LanguageEnum.ENGLISH));
    }

    @GetMapping("role_id/{roleId}")
    @Operation(summary = "通过id查角色")
    public CommonResult<RoleRespVo> getRoleById(@PathVariable("roleId") Long roleId) {
        RolePo rolePo = roleService.getRoleById(roleId);
        log.info("rolePo: {}", rolePo);
        return CommonResult.success(RoleConvert.INSTANCE.poToVo(rolePo));
    }
}
