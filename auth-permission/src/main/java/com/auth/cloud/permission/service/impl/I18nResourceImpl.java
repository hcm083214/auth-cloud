package com.auth.cloud.permission.service.impl;

import com.auth.cloud.permission.convert.I18nResourceConvert;
import com.auth.cloud.permission.mapper.I18nResourceMapper;
import com.auth.cloud.permission.pojo.po.I18nResourcePo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nAddReqVo;
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

    private  List<I18nResourcePo> getI18nResources(List<I18nAddReqVo> i18nSearchReqVos) {
        QueryWrapper<I18nResourcePo> query = new QueryWrapper<>();
        Set<String> locales = new HashSet<>();
        Set<String> modules = new HashSet<>();
        Set<String> keys = new HashSet<>();
        i18nSearchReqVos.forEach(i18nResourceReqVo -> {
            locales.add(i18nResourceReqVo.getLocale());
            modules.add(i18nResourceReqVo.getI18nModule());
            keys.add(i18nResourceReqVo.getI18nKey());
        });
        query.in("locale", locales)
                .in("i18n_module", modules)
                .in("i18n_key", keys);
        return i18nResourceMapper.selectList(query);
    }

    private void addListToMap(Map<String, List<I18nResourcePo>> map, String key, I18nResourcePo po) {
        List<I18nResourcePo> pos = map.get(key);
        pos.add(po);
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

    private Map<String, List<I18nResourcePo>> filterI18nResources(List<I18nAddReqVo> vos, List<I18nResourcePo> pos) {
        Map<String, List<I18nResourcePo>> map = new HashMap<>();
        if (pos.isEmpty()) {
            map.put("add", I18nResourceConvert.INSTANCE.vosToPos(vos));
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
                    addListToMap(map, "add", I18nResourceConvert.INSTANCE.voToPo(vo));
                } else {
                    pos.stream().forEach((po) -> {
                        String k = po.getLocale() + po.getI18nModule() + po.getI18nKey();
                        if (k.equals(key)) {
                            po.setI18nValue(vo.getI18nValue());
                            addListToMap(map, "update", po);
                        }
                    });

                }
            });
        }
        return map;
    }

    private Boolean insertBatch(List<I18nResourcePo> pos) {
        if (pos.isEmpty()) {
            return true;
        }
        pos.forEach(po -> {
            po.setCreateTime(LocalDateTime.now());
            po.setUpdateTime(LocalDateTime.now());
        });
        log.info("sys_i18n_resource insertBatch {},i18nResourcePos: {}", pos.size(), pos);
        return saveBatch(pos);
        // return i18nResourceMapper.insertBatchSomeColumn(i18nResourcePos);
    }

    private Boolean updateBatch(List<I18nResourcePo> pos) {
        if (pos.isEmpty()) {
            return true;
        }
        pos.forEach(po -> {
            po.setUpdateTime(LocalDateTime.now());
        });
        log.info("sys_i18n_resource updateBatch {},i18nResourcePos: {}", pos.size(), pos);
        return updateBatchById(pos);
    }

    @Override
    public List<I18nResourcePo> getI18nList(String locale) {
        Map<String, Object> queryMap = new HashMap<>(1);
        queryMap.put("locale", locale);
        return i18nResourceMapper.selectByMap(queryMap);
    }

    @Override
    public Page<I18nResourcePo> getI18nPageList(Page page, I18nSearchReqVo i18nSearchReqVo) {
        QueryWrapper<I18nResourcePo> query = new QueryWrapper();
        query.like(StringUtils.isNotBlank(i18nSearchReqVo.getI18nModule()),
                        "i18n_module", i18nSearchReqVo.getI18nModule())
                .like(StringUtils.isNotBlank(i18nSearchReqVo.getI18nKey()),
                        "i18n_key", i18nSearchReqVo.getI18nKey())
                .eq(StringUtils.isNotBlank(i18nSearchReqVo.getLocale()),
                        "locale", i18nSearchReqVo.getLocale());
        return i18nResourceMapper.selectPage(page, query);
    }

    @Override
    public Integer addI18nResource(List<I18nAddReqVo> i18nAddReqVos) {
        List<I18nResourcePo> i18nResources = getI18nResources(i18nAddReqVos);
        if (i18nAddReqVos.isEmpty()) {
            return 0;
        } else {
            Map<String, List<I18nResourcePo>> filterMap = filterI18nResources(i18nAddReqVos, i18nResources);
            insertBatch(filterMap.get("add"));
            updateBatch(filterMap.get("update"));
            return filterMap.get("add").size() + filterMap.get("update").size();
        }
    }
}
