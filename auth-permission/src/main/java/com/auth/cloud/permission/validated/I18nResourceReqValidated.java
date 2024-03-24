package com.auth.cloud.permission.validated;

import com.auth.cloud.common.exception.BadRequestException;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nSearchReqVo;


import java.util.List;

/**
 * RequestBody 校验失效
 * @author 黄灿民
 * @date 2024/03/24
 */
public class I18nResourceReqValidated {

    public static void addValidated(I18nSearchReqVo i18nSearchReqVo) {
        if (i18nSearchReqVo.getI18nModule() == null) {
            throw new BadRequestException("i18nModule 未传");
        }
        if (i18nSearchReqVo.getI18nValue() == null) {
            throw new BadRequestException("i18nValue 未传");
        }
        if (i18nSearchReqVo.getLocale() == null) {
            throw new BadRequestException("locale 未传");
        }
    }

    public static void addListValidated(List<I18nSearchReqVo> i18nSearchReqVos) {
        if (i18nSearchReqVos == null || i18nSearchReqVos.isEmpty()) {
            throw new BadRequestException("i18nResourceReqVos 未传");
        }
        i18nSearchReqVos.forEach(i18nResourceReqVo -> addValidated(i18nResourceReqVo));
    }
}
