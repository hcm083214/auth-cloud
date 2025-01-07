package com.auth.cloud.i18n.core;

import com.auth.cloud.i18n.config.LocaleConfiguration;
import com.auth.cloud.i18n.enums.LanguageEnum;
import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;

import java.util.Locale;

/**
 * @author 黄灿民
 * @date 2024/01/20
 */
public class I18n {
    private final MessageSource messageSource;

    public I18n(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private Locale getLanguage(LanguageEnum language) {
        return new Locale(language.getLanguage(), language.getCountry());
    }

    public String get(String code) {
        return messageSource.getMessage(code, null, LocaleConfiguration.getLocaleFromRequest());
    }

    public String get(String code, @Nullable Object[] args) {
        return messageSource.getMessage(code, args, LocaleConfiguration.getLocaleFromRequest());
    }

    public String get(String code, LanguageEnum language) {
        Locale lang = getLanguage(language);
        System.out.println(lang);
        return messageSource.getMessage(code, null, lang);
    }

    public String get(String code, @Nullable Object[] args, LanguageEnum language) {
        Locale lang = getLanguage(language);
        return messageSource.getMessage(code, args, lang);
    }
}
