package com.auth.cloud.permission.service;


import com.auth.cloud.permission.pojo.po.I18nResourcePo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nSearchReqVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface I18nResourceService {
    List<I18nResourcePo> getI18nList(String locale);

    Page<I18nResourcePo> getI18nPageList(Page page, I18nSearchReqVo i18NSearchReqVo);

    Integer addI18nResource(List<I18nSearchReqVo> i18NSearchReqVos);
}
