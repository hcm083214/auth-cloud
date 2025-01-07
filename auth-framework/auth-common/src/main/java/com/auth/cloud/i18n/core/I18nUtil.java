package com.auth.cloud.i18n.core;

import com.auth.cloud.i18n.config.I18nAutoConfiguration;
import com.auth.cloud.i18n.config.LocaleConfiguration;
import com.auth.cloud.i18n.enums.LanguageEnum;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Optional;

/**
 * @author 黄灿民
 * @date 2024/01/23
 */
public class I18nUtil {
    private static final MessageSource messageSource;

    static {
        // 通过构造函数注入 MessageSource
        messageSource = I18nAutoConfiguration.getBean(MessageSource.class);
    }



    private static Locale getLanguage(LanguageEnum language) {
        return new Locale(language.getLanguage(), language.getCountry());
    }

    public static String get(String code) {
        validateCode(code);
        return messageSource.getMessage(code, null, LocaleConfiguration.getLocaleFromRequest());
    }

    public static String get(String code, Object[] args) {
        validateCode(code);
        return messageSource.getMessage(code, args, LocaleConfiguration.getLocaleFromRequest());
    }

    public static String get(String code, LanguageEnum language) {
        validateCode(code);
        Locale lang = getLanguage(language);
        return messageSource.getMessage(code, null, lang);
    }

    public static String get(String code, Object[] args, LanguageEnum language) {
        validateCode(code);
        Locale lang = getLanguage(language);
        return messageSource.getMessage(code, args, lang);
    }

    private static void validateCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
    }
}
