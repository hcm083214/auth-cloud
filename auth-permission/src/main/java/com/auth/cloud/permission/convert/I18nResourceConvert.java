package com.auth.cloud.permission.convert;

import com.auth.cloud.permission.pojo.po.I18nResourcePo;
import com.auth.cloud.permission.pojo.vo.respvo.I18nResourceRespVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface I18nResourceConvert {
    I18nResourceConvert  INSTANCE = Mappers.getMapper(I18nResourceConvert.class);

    I18nResourceRespVo poToVo(I18nResourcePo i18nResourcePo);

    default List<I18nResourceRespVo> posToVos(List<I18nResourcePo> i18nResourcePos) {
        if (i18nResourcePos == null || i18nResourcePos.size() == 0) {
            return null;
        }
        return i18nResourcePos.stream()
                .map(this::poToVo)
                .collect(Collectors.toList());
    }
}
