package com.auth.cloud.permission.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@Slf4j
@Validated
@Tag(name = "权限管理后台 - 权限", description = "权限查询相关接口")
public class PermissionController {
}
