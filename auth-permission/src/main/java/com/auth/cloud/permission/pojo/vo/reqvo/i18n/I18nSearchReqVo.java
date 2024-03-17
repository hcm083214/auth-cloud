package com.auth.cloud.permission.pojo.vo.reqvo.i18n;

import com.auth.cloud.common.pojo.Base;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class I18nSearchReqVo extends Base {

    public interface PageGroup {
    }

    public interface AddGroup {
    }

    public interface EditGroup {
    }

    /**
     * id
     */
    @NotNull(groups = {EditGroup.class},message = "i18nId 未传")
    private Long i18nId;

    /**
     * 语言环境
     */
    @NotBlank(groups = {AddGroup.class, EditGroup.class},message = "locale 未传")
    private String locale;

    /**
     * 模块
     */
    @NotBlank(groups = {AddGroup.class, EditGroup.class},message = "i18nModule 未传")
    private String i18nModule;

    /**
     * 键
     */
    @NotBlank(groups = {AddGroup.class, EditGroup.class},message = "i18nKey 未传")
    private String i18nKey;

    /**
     * 值
     */
    @NotBlank(groups = {AddGroup.class, EditGroup.class},message = "i18nValue 未传")
    private String i18nValue;

    /**
     * 页码
     */
    @NotNull(groups = {PageGroup.class},message = "current 未传")
    private Integer current;

    /**
     * 每页条数
     */
    @NotNull(groups = {PageGroup.class},message = "size 未传")
    private Integer size;
}
