package com.auth.cloud.permission.controller;


import com.auth.cloud.common.pojo.CommonResult;

import com.auth.cloud.i18n.core.I18n;
import com.auth.cloud.permission.convert.RoleConvert;
import com.auth.cloud.permission.pojo.po.RolePo;
import com.auth.cloud.permission.pojo.vo.respvo.RoleRespVo;
import com.auth.cloud.permission.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


/**
 * @author 黄灿民
 * @date 2024/01/03
 */
@RestController
@RequestMapping("/role")
@Slf4j
@Validated
@Tag(name = "权限管理后台 - 角色", description = "角色设计相关接口")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @GetMapping("role_id/{roleId}")
    @Operation(summary = "通过id查角色")
    public CommonResult<RoleRespVo> getRoleById(@PathVariable("roleId") @NotNull(message = "roleId不能为空") Long roleId) {
        RolePo rolePo = roleService.getRoleById(roleId);
        log.info("rolePo: {}", rolePo);
        return CommonResult.success(RoleConvert.INSTANCE.poToVo(rolePo));
    }
}
