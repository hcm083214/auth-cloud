package com.auth.cloud.permission.convert;

import com.auth.cloud.permission.pojo.po.I18nResourcePo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nAddReqVo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nEditReqVo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nSearchReqVo;
import com.auth.cloud.permission.pojo.vo.respvo.I18nResourceRespVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface I18nResourceConvert {
    I18nResourceConvert INSTANCE = Mappers.getMapper(I18nResourceConvert.class);

    I18nResourceRespVo poToVo(I18nResourcePo i18nResourcePo);

    /**
     * 将I18nResourcePo对象列表转换为I18nResourceRespVo对象列表。
     *
     * @param i18nResourcePos I18nResourcePo对象列表，不可为null。
     * @return 转换后的I18nResourceRespVo对象列表，如果输入为空，则返回空列表。
     */
    default List<I18nResourceRespVo> posToVos(List<I18nResourcePo> i18nResourcePos) {
        if (i18nResourcePos == null || i18nResourcePos.size() == 0) {
            return new ArrayList<>();
        }
        return i18nResourcePos.stream()
                .map(this::poToVo)
                .collect(Collectors.toList());
    }

    default Page<I18nResourceRespVo> posToVos(Page<I18nResourcePo> pos) {
        Page<I18nResourceRespVo> result = new Page<>();
        result.setRecords(posToVos(pos.getRecords()))
                .setSize(pos.getSize())
                .setTotal(pos.getTotal())
                .setCurrent(pos.getCurrent());
        return result;
    }

    I18nResourcePo voToPo(I18nAddReqVo i18nAddReqVo);
    I18nResourcePo voToPo(I18nEditReqVo i18nEditReqVo);
    I18nResourcePo voToPo(I18nSearchReqVo i18nSearchReqVo);
    default List<I18nResourcePo> addVosToPos(List<I18nAddReqVo> reqVos) {
        if (reqVos == null || reqVos.size() == 0) {
            return new ArrayList<>();
        }
        return reqVos.stream()
                .map(I18nResourceConvert.INSTANCE::voToPo)
                .collect(Collectors.toList());
    }

    default List<I18nResourcePo> editVosToPos(List<I18nEditReqVo> reqVos) {
        if (reqVos == null || reqVos.size() == 0) {
            return new ArrayList<>();
        }
        return reqVos.stream()
                .map(I18nResourceConvert.INSTANCE::voToPo)
                .collect(Collectors.toList());
    }

}
