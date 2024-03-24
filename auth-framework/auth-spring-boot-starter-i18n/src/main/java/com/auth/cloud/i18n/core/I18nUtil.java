package com.auth.cloud.i18n.core;

import com.auth.cloud.i18n.config.I18nAutoConfiguration;
import com.auth.cloud.i18n.enums.LanguageEnum;
import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;

import java.util.Locale;

/**
 * @author 黄灿民
 * @date 2024/01/23
 */
public class I18nUtil {

    private static class Lazy {
        // 使用懒加载方式实例化MessageSource对象
        private static final MessageSource messageSource = I18nAutoConfiguration.getBean(MessageSource.class);
    }

    private static MessageSource getInstance() {
        return Lazy.messageSource;
    }

    private static Locale getLanguage(LanguageEnum language) {
        return new Locale(language.getLanguage(), language.getCountry());
    }

    public static String get(String code) {
        return getInstance().getMessage(code, null, Locale.getDefault());
    }

    public static String get(String code, @Nullable Object[] args) {
        return getInstance().getMessage(code, args, Locale.getDefault());
    }

    public static String get(String code, LanguageEnum language) {
        Locale lang = getLanguage(language);
        System.out.println(lang);
        return getInstance().getMessage(code, null, lang);
    }

    public static String get(String code, @Nullable Object[] args, LanguageEnum language) {
        Locale lang = getLanguage(language);
        return getInstance().getMessage(code, args, lang);
    }
}
