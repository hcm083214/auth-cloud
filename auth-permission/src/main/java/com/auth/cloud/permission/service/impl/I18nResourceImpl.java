package com.auth.cloud.permission.service.impl;

import com.auth.cloud.permission.mapper.I18nResourceMapper;
import com.auth.cloud.permission.pojo.po.I18nResourcePo;
import com.auth.cloud.permission.service.I18nResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 黄灿民
 * @date 2024/03/17
 */
@Service
public class I18nResourceImpl implements I18nResourceService {

    @Autowired
    I18nResourceMapper i18nResourceMapper;

    @Override
    public List<I18nResourcePo> getI18nList(String locale) {
        Map<String, Object> queryMap = new HashMap<>(1);
        queryMap.put("locale", locale);
        return i18nResourceMapper.selectByMap(queryMap);
    }
}
