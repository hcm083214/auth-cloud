package com.auth.cloud.permission.validated;

import com.auth.cloud.common.exception.BadRequestException;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nAddReqVo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nEditReqVo;
import org.springframework.util.StringUtils;


import java.util.List;
import java.util.Objects;

/**
 * RequestBody 校验失效
 * @author 黄灿民
 * @date 2024/03/24
 */
public class I18nResourceReqValidated {

    private static void addValidated(I18nAddReqVo i18nAddReqVo) {
        validateField("i18nModule", i18nAddReqVo.getI18nModule());
        validateField("i18nValue", i18nAddReqVo.getI18nValue());
        validateField("locale", i18nAddReqVo.getLocale());
    }

    private static void editValidated(I18nEditReqVo i18nEditReqVo) {
        validateField("i18nModule", i18nEditReqVo.getI18nModule());
        validateField("i18nValue", i18nEditReqVo.getI18nValue());
        validateField("locale", i18nEditReqVo.getLocale());
        validateField("i18nId", i18nEditReqVo.getI18nId());
    }

    private static void validateField(String fieldName, Object value) {
        if(value instanceof String){
            if (Objects.isNull(value) || ! StringUtils.hasLength(((String) value).trim())) {
                throw new BadRequestException(fieldName + "未传值");
            }
        }
        if (value instanceof Integer){
            if (Objects.isNull(value) || ((Integer) value) <= 0) {
                throw new BadRequestException(fieldName + "未传值");
            }
        }

    }

    public static void addListValidated(List<I18nAddReqVo> i18nAddReqVos) {
        if (i18nAddReqVos == null || i18nAddReqVos.isEmpty()) {
            throw new BadRequestException("i18nResourceReqVos 未传");
        }
        i18nAddReqVos.forEach(i18nAddReqVo -> addValidated(i18nAddReqVo));
    }

    public static void editListValidated(List<I18nEditReqVo> i18nEditReqVos) {
        if (i18nEditReqVos == null || i18nEditReqVos.isEmpty()) {
            throw new BadRequestException("i18nEditReqVos 未传");
        }
        i18nEditReqVos.forEach(i18nEditReqVo -> editValidated(i18nEditReqVo));
    }
}
