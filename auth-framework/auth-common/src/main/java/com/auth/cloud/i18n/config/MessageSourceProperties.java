package com.auth.cloud.i18n.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

/**
 * 国际化配置项
 *
 * @author 黄灿民
 * @date 2024/01/17
 */
@ConfigurationProperties("auth.i18n")
@Data
public class MessageSourceProperties {

    // 基础文件名
    private String basename = "message";

    private String localeParamName = "lang";

    private Locale defaultLocale = Locale.SIMPLIFIED_CHINESE;

    // 默认编码
    private String defaultEncoding = "UTF-8";

    // 是否使用代码作为默认消息
    private boolean useCodeAsDefaultMessage = true;
}
