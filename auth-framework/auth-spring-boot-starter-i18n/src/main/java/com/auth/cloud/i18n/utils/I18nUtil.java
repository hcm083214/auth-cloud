package com.auth.cloud.i18n.utils;


import com.auth.cloud.i18n.enums.LanguageEnum;
import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;

import java.util.Locale;

/**
 * 国际化工具类
 *
 * @author 黄灿民
 * @date 2024/01/03
 */
public class I18nUtil {

    private static Locale getLanguage(LanguageEnum language) {
        return new Locale(language.getLanguage(), language.getCountry());
    }

    public static String get(String code) {
        return getMessageSource().getMessage(code, null, Locale.getDefault());
    }

    public static String get(String code, @Nullable Object[] args) {
        return getMessageSource().getMessage(code, args, Locale.getDefault());
    }

    public static String get(String code, LanguageEnum language) {
        Locale lang = getLanguage(language);
        System.out.println(lang);
        return getMessageSource().getMessage(code, null, lang);
    }

    public static String get(String code, @Nullable Object[] args, LanguageEnum language) {
        Locale lang = getLanguage(language);
        return getMessageSource().getMessage(code, args, lang);
    }

    private static class Lazy {
        // 使用懒加载方式实例化MessageSource对象
        private static final MessageSource messageSource = SpringContextUtil.getBean(MessageSource.class);
    }

    private static MessageSource getMessageSource() {
        return Lazy.messageSource;
    }


}
