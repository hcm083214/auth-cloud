package com.auth.cloud.permission.controller;

import com.auth.cloud.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/resource")
@Slf4j
@Validated
@Tag(name = "权限管理后台 - 资源", description = "页面和按钮资源查询相关接口")
public class ResourceController {


}
