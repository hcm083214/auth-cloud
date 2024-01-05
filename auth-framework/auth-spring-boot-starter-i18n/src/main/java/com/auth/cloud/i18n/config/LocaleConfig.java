package com.auth.cloud.i18n.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * @author 黄灿民
 * @date 2024/01/03
 */
@Configuration
public class LocaleConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        System.out.println("test");
        Locale.setDefault(Locale.CHINA);
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        // 设置是否回退到系统本地
        messageSource.setFallbackToSystemLocale(false);
        // 设置是否使用代码作为默认消息
        messageSource.setUseCodeAsDefaultMessage(true);
        //设置国际化文件存储路径和名称    i18n目录，messages文件名
        messageSource.setBasename("i18n/messages");
        return messageSource;
    }
}
