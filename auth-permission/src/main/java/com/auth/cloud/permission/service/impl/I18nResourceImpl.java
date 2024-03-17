package com.auth.cloud.permission.service.impl;

import com.auth.cloud.permission.mapper.I18nResourceMapper;
import com.auth.cloud.permission.pojo.po.I18nResourcePo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nSearchReqVo;
import com.auth.cloud.permission.service.I18nResourceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author 黄灿民
 * @date 2024/03/17
 */
@Service
@Slf4j
public class I18nResourceImpl
        extends ServiceImpl<I18nResourceMapper, I18nResourcePo>
        implements I18nResourceService {

    @Autowired
    I18nResourceMapper i18nResourceMapper;

    private List<I18nResourcePo> getI18nResources(List<I18nSearchReqVo> i18NSearchReqVos) {
        QueryWrapper<I18nResourcePo> query = new QueryWrapper<>();
        Set<String> locales = new HashSet<>();
        Set<String> modules = new HashSet<>();
        Set<String> keys = new HashSet<>();
        i18NSearchReqVos.forEach(i18nResourceReqVo -> {
            locales.add(i18nResourceReqVo.getLocale());
            modules.add(i18nResourceReqVo.getI18nModule());
            keys.add(i18nResourceReqVo.getI18nKey());
        });
        query.in("locale", locales)
                .in("i18n_module", modules)
                .in("i18n_key", keys);
        return i18nResourceMapper.selectList(query);
    }

    private void addListToMap(Map<String, List<I18nSearchReqVo>> map, String key, I18nSearchReqVo vo) {
        List<I18nSearchReqVo> vos = map.get(key);
        vos.add(vo);
    }

    /**
     * 过滤国际化资源。
     * 该方法用于根据现有的国际化资源数据库条目（pos）来过滤和分类新的国际化资源请求（vos）。
     * 如果数据库条目为空，则所有请求都被认为是新增资源。
     * 如果数据库不为空，则通过比较请求和现有资源的locale、i18nModule和i18nKey来决定是新增资源还是更新现有资源。
     *
     * @param vos 国际化资源请求列表，这些是待处理的资源，可能是新增也可能是更新。
     * @param pos 现有的国际化资源数据库条目列表，用于比较和过滤请求。
     * @return 返回一个映射，包含两类资源："add"列表中的资源表示需新增的资源，"update"列表中的资源表示需更新的资源。
     */

    private Map<String, List<I18nSearchReqVo>> filterI18nResources(List<I18nSearchReqVo> vos, List<I18nResourcePo> pos) {
        Map<String, List<I18nSearchReqVo>> map = new HashMap<>();
        if (pos.isEmpty()) {
            map.put("add", vos);
            return map;
        } else {
            Set<String> keys = new HashSet<>();
            pos.forEach(po -> {
                keys.add(po.getLocale() + po.getI18nModule() + po.getI18nKey());
            });
            map.put("add", new ArrayList<>());
            map.put("update", new ArrayList<>());
            vos.forEach(vo -> {
                String key = vo.getLocale() + vo.getI18nModule() + vo.getI18nKey();
                if (!keys.contains(key)) {
                    addListToMap(map, "add", vo);
                } else {
                    pos.stream().forEach((po) -> {
                        String k = po.getLocale() + po.getI18nModule() + po.getI18nKey();
                        if (k.equals(key)) {
                            vo.setI18nId(po.getI18nId());
                        }
                    });
                    addListToMap(map, "update", vo);
                }
            });
        }
        return map;
    }

    private Boolean insertBatch(List<I18nSearchReqVo> vos) {
        List<I18nResourcePo> i18nResourcePos = new ArrayList<>();
        if (vos.isEmpty()) {
            return true;
        }
        vos.forEach(i18nResourceReqVo -> {
            I18nResourcePo i18nResourcePo = new I18nResourcePo();
            Optional.ofNullable(i18nResourceReqVo.getLocale()).ifPresent(locale -> i18nResourcePo.setLocale(locale));
            Optional.ofNullable(i18nResourceReqVo.getI18nModule()).ifPresent(i18nModule -> i18nResourcePo.setI18nModule(i18nModule));
            Optional.ofNullable(i18nResourceReqVo.getI18nKey()).ifPresent(i18nKey -> i18nResourcePo.setI18nKey(i18nKey));
            Optional.ofNullable(i18nResourceReqVo.getI18nValue()).ifPresent(i18nValue -> i18nResourcePo.setI18nValue(i18nValue));
            i18nResourcePo.setCreateTime(LocalDateTime.now());
            i18nResourcePo.setUpdateTime(LocalDateTime.now());
            i18nResourcePos.add(i18nResourcePo);
        });
        log.info("sys_i18n_resource insertBatch {},i18nResourcePos: {}", i18nResourcePos.size(), i18nResourcePos);
        return saveBatch(i18nResourcePos);
//        return i18nResourceMapper.insertBatchSomeColumn(i18nResourcePos);
    }

    private Boolean updateBatch(List<I18nSearchReqVo> vos) {
        List<I18nResourcePo> i18nResourcePos = new ArrayList<>();
        if (vos.isEmpty()) {
            return true;
        }
        vos.forEach(i18nResourceReqVo -> {
            I18nResourcePo i18nResourcePo = new I18nResourcePo();
            Optional.ofNullable(i18nResourceReqVo.getI18nId()).ifPresent(i18nId -> i18nResourcePo.setI18nId(i18nId));
            Optional.ofNullable(i18nResourceReqVo.getLocale()).ifPresent(locale -> i18nResourcePo.setLocale(locale));
            Optional.ofNullable(i18nResourceReqVo.getI18nModule()).ifPresent(i18nModule -> i18nResourcePo.setI18nModule(i18nModule));
            Optional.ofNullable(i18nResourceReqVo.getI18nKey()).ifPresent(i18nKey -> i18nResourcePo.setI18nKey(i18nKey));
            i18nResourcePo.setUpdateTime(LocalDateTime.now());
            Optional.ofNullable(i18nResourceReqVo.getI18nValue()).ifPresent(i18nValue -> i18nResourcePo.setI18nValue(i18nValue));
            i18nResourcePos.add(i18nResourcePo);
        });
        log.info("sys_i18n_resource updateBatch {},i18nResourcePos: {}", i18nResourcePos.size(), i18nResourcePos);
        return updateBatchById(i18nResourcePos);
    }

    @Override
    public List<I18nResourcePo> getI18nList(String locale) {
        Map<String, Object> queryMap = new HashMap<>(1);
        queryMap.put("locale", locale);
        return i18nResourceMapper.selectByMap(queryMap);
    }

    @Override
    public Page<I18nResourcePo> getI18nPageList(Page page, I18nSearchReqVo i18NSearchReqVo) {
        QueryWrapper<I18nResourcePo> query = new QueryWrapper();
        query.like(StringUtils.isNotBlank(i18NSearchReqVo.getI18nModule()),
                        "i18n_module", i18NSearchReqVo.getI18nModule())
                .like(StringUtils.isNotBlank(i18NSearchReqVo.getI18nKey()),
                        "i18n_key", i18NSearchReqVo.getI18nKey())
                .eq(StringUtils.isNotBlank(i18NSearchReqVo.getLocale()),
                        "locale", i18NSearchReqVo.getLocale());
        return i18nResourceMapper.selectPage(page, query);
    }

    @Override
    public Integer addI18nResource(List<I18nSearchReqVo> i18NSearchReqVos) {
        List<I18nResourcePo> i18nResources = getI18nResources(i18NSearchReqVos);
        if (i18NSearchReqVos.isEmpty()) {
            return 0;
        } else {
            Map<String, List<I18nSearchReqVo>> filterMap = filterI18nResources(i18NSearchReqVos, i18nResources);
            insertBatch(filterMap.get("add"));
            updateBatch(filterMap.get("update"));
            return filterMap.get("add").size() + filterMap.get("update").size();
        }
    }
}
