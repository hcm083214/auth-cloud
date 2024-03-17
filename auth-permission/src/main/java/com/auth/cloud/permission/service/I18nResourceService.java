package com.auth.cloud.permission.service;



import com.auth.cloud.permission.pojo.po.I18nResourcePo;

import java.util.List;

public interface I18nResourceService {
    List<I18nResourcePo> getI18nList(String locale);
}
