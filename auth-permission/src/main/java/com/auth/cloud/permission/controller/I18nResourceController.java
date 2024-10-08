package com.auth.cloud.permission.controller;

import com.auth.cloud.common.pojo.CommonResult;
import com.auth.cloud.i18n.core.I18nUtil;
import com.auth.cloud.permission.convert.I18nResourceConvert;
import com.auth.cloud.permission.pojo.po.I18nResourcePo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nAddReqVo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nEditReqVo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nSearchReqVo;
import com.auth.cloud.permission.pojo.vo.respvo.I18nResourceRespVo;
import com.auth.cloud.permission.service.I18nResourceService;
import com.auth.cloud.permission.validated.I18nResourceReqValidated;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 黄灿民
 * @date 2024/03/17
 */
@RestController
@Tag(name = "国际化语言资源管理", description = "国际化语言资源管理相关接口")
@RequestMapping("/language")
@Slf4j
public class I18nResourceController {

    @Autowired
    private I18nResourceService i18nResourceService;

    @GetMapping("/locale")
    @Operation(summary = "国际化语言包获取", description = "根据语言环境获取国际化语言包")
    public CommonResult<List<I18nResourceRespVo>> getI18nPackageByLocale() {
        List<I18nResourcePo> sysI18nList = i18nResourceService.list();
        List<I18nResourceRespVo> i18nResourceRespVos = I18nResourceConvert.INSTANCE.posToVos(sysI18nList);
        return CommonResult.success(i18nResourceRespVos);
    }

    @GetMapping("/locale/{locale}")
    @Operation(summary = "国际化语言包获取", description = "根据语言环境获取国际化语言包")
    public CommonResult<List<I18nResourceRespVo>> getI18nPackageByLocale(@PathVariable @NotBlank String locale) {
        List<I18nResourcePo> sysI18nList = i18nResourceService.getI18nList(locale);
        return CommonResult.success(I18nResourceConvert.INSTANCE.posToVos(sysI18nList));
    }

    @Operation(summary = "分页查询国际化资源", description = "根据条件分页查询国际化资源")
    @GetMapping("/list")
    public CommonResult<Page<I18nResourceRespVo>> getI18nResources(
           @Valid I18nSearchReqVo i18nSearchReqVo) {
        Page<I18nResourcePo> sysI18nList =
                i18nResourceService.getI18nPageList(
                        new Page<>(i18nSearchReqVo.getCurrent(), i18nSearchReqVo.getSize())
                        , i18nSearchReqVo);
        return CommonResult.success(I18nResourceConvert.INSTANCE.posToVos(sysI18nList));
    }

    @PostMapping()
    @Operation(summary = "新增国际化资源", description = "新增国际化资源")
    public CommonResult<String> addI18nResource(
          @RequestBody @Valid List<I18nAddReqVo> i18nAddReqVos) {
        I18nResourceReqValidated.addListValidated(i18nAddReqVos);
        try {
            Integer addedCount = i18nResourceService.addI18nResource(i18nAddReqVos);
            String successMessage = I18nUtil.get("add.success", new Integer[]{addedCount});
            return CommonResult.success(successMessage);
        } catch (Exception e) {
            log.error("Failed to add i18n resources", e);
            throw new RuntimeException(I18nUtil.get("add.failed"));
        }
    }

    @DeleteMapping("/i18n_id/{i18nId}")
    @Operation(summary = "删除国际化资源", description = "删除国际化资源")
    public CommonResult<String> deleteI18nResource(@PathVariable("i18nId") @Valid
                                                       @NotNull(message = "i18nId不能为空")
                                                       @Min(value = 1L, message = "i18nId不能小于1") Long i18nId){
        i18nResourceService.deleteI18nResource(i18nId);
        String successMessage = I18nUtil.get("delete.success");
        return CommonResult.success(successMessage);
    }

    @PutMapping()
    @Operation(summary = "更新国际化资源", description = "更新国际化资源")
    public CommonResult<String> editI18nResource(@RequestBody @Valid I18nEditReqVo i18nEditReqVo) {
        try {
            i18nResourceService.editI18nResource(i18nEditReqVo);
            String successMessage = I18nUtil.get("edit.success");
            return CommonResult.success(successMessage);
        } catch (Exception e) {
            log.error("Failed to edit i18n resources", e);
            throw new RuntimeException(I18nUtil.get("edit.failed"));
        }
    }
}

