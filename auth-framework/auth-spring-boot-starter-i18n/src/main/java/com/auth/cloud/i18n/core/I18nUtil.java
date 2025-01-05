package com.auth.cloud.i18n.core;

import com.auth.cloud.i18n.config.I18nAutoConfiguration;
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

    /**
     * 从请求头中获取 Accept-Language 的值
     *
     * @return 请求头中的 Locale，如果没有则返回默认 Locale
     */
    public static Locale getLocaleFromRequest() {
        // 获取当前请求的属性，可能为 null 如果在非 Servlet 环境下运行
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            // 获取 HTTP 请求对象
            HttpServletRequest request = attributes.getRequest();
            // 获取请求头中的所有 Locale
            Enumeration<Locale> locales = request.getLocales();
            // 使用 Stream API 处理可能为空的 Enumeration，返回第一个 Locale 或默认 Locale
            return Optional.ofNullable(locales)
                    .filter(Enumeration::hasMoreElements)
                    .map(Enumeration::nextElement)
                    .orElse(LocaleContextHolder.getLocale());
        }
        // 如果没有请求属性，则返回默认 Locale
        return LocaleContextHolder.getLocale();
    }

    private static Locale getLanguage(LanguageEnum language) {
        return new Locale(language.getLanguage(), language.getCountry());
    }

    public static String get(String code) {
        validateCode(code);
        return messageSource.getMessage(code, null, getLocaleFromRequest());
    }

    public static String get(String code, Object[] args) {
        validateCode(code);
        return messageSource.getMessage(code, args, getLocaleFromRequest());
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
