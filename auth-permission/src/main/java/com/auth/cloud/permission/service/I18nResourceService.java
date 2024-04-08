package com.auth.cloud.permission.service;


import com.auth.cloud.permission.pojo.po.I18nResourcePo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nAddReqVo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nEditReqVo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nSearchReqVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface I18nResourceService {
    List<I18nResourcePo> getI18nList(String locale);

    Page<I18nResourcePo> getI18nPageList(Page page, I18nSearchReqVo i18nSearchReqVo);

    Integer addI18nResource(List<I18nAddReqVo> i18nAddReqVos);

    void editI18nResource(I18nEditReqVo i18nEditReqVos);

    void deleteI18nResource(Long i18nId);
}
