package com.auth.cloud.permission.controller;

import com.auth.cloud.common.pojo.CommonResult;
import com.auth.cloud.permission.convert.I18nResourceConvert;
import com.auth.cloud.permission.pojo.po.I18nResourcePo;
import com.auth.cloud.permission.pojo.vo.respvo.I18nResourceRespVo;
import com.auth.cloud.permission.service.I18nResourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄灿民
 * @date 2024/03/17
 */
@RestController
@Tag(name = "国际化资源管理", description = "国际化资源管理相关接口")
@RequestMapping("i18n")
public class I18nResourceController {

    @Autowired
    private I18nResourceService i18nResourceService;

    @GetMapping("/locale/{locale}")
    @Operation(summary = "国际化语言包查询", description = "根据语言环境获取全部的国际化数据")
    public CommonResult<List<I18nResourceRespVo>> getI18nAllList(@PathVariable String locale) {
        List<I18nResourcePo> sysI18nList = i18nResourceService.getI18nList(locale);
        return CommonResult.success(I18nResourceConvert.INSTANCE.posToVos(sysI18nList));
    }
}
