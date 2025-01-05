package com.auth.cloud.i18n.enums;

import lombok.Getter;

/**
 *  语言枚举
 * @author 黄灿民
 * @date 2024/01/03
 */
@Getter
public enum LanguageEnum {

    /**
     * 中文
     */
    CHINESE("zh_CN","zh","CN"),

    /**
     * 英文
     */
    ENGLISH("en_US","en","US");

    private final String code;

    private final String language;

    private final String  country;

    LanguageEnum(String code, String language, String country) {
        this.code = code;
        this.language = language;
        this.country = country;
    }
}
