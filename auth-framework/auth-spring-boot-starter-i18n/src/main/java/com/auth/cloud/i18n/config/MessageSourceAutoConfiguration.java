package com.auth.cloud.i18n.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * Spring 中的国际化使用
 *
 * @author 黄灿民
 * @date 2024/01/03
 */
@Configuration
// 将与配置文件绑定好的某个类注入到容器中，使其生效
@EnableConfigurationProperties(MessageSourceProperties.class)
public class MessageSourceAutoConfiguration {

    private final MessageSourceProperties messageSourceProperties;

    // 构建该自动配置类时将与配置文件绑定的配置类作为入参传递进去
    public MessageSourceAutoConfiguration(MessageSourceProperties messageSourceProperties) {
        this.messageSourceProperties = messageSourceProperties;
    }

    @Bean
    public ResourceBundleMessageSource  messageSource() {
        Locale.setDefault(Locale.CHINA);
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource ();
        messageSource.setDefaultEncoding(messageSourceProperties.getDefaultEncoding());
        // 设置是否回退到系统本地
        messageSource.setFallbackToSystemLocale(false);
        // 设置是否使用代码作为默认消息
        messageSource.setUseCodeAsDefaultMessage(messageSourceProperties.isUseCodeAsDefaultMessage());
        //设置国际化文件存储路径和名称    i18n目录，messages文件名
        messageSource.setBasename(messageSourceProperties.getBasename());
        return messageSource;
    }

}
