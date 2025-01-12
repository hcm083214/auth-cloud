package com.auth.cloud.i18n.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Spring 中的国际化使用
 *
 * @author 黄灿民
 * @date 2024/01/03
 */
@Configuration
@EnableConfigurationProperties(MessageSourceProperties.class)
public class MessageSourceAutoConfiguration {

    // 与配置文件绑定的配置类
    private final MessageSourceProperties messageSourceProperties;

    // 构建该自动配置类时将与配置文件绑定的配置类作为入参传递进去
    public MessageSourceAutoConfiguration(MessageSourceProperties messageSourceProperties) {
        if (messageSourceProperties == null) {
            throw new IllegalArgumentException("MessageSourceProperties cannot be null");
        }
        this.messageSourceProperties = messageSourceProperties;
    }

    /**
     * 创建一个 ResourceBundleMessageSource 实例
     *
     * @return ResourceBundleMessageSource 实例，用于处理国际化消息
     */
    @Bean(name = "customMessageSource")
    @Primary
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        // 设置消息源的默认编码
        messageSource.setDefaultEncoding(messageSourceProperties.getDefaultEncoding());
        // 设置是否回退到系统本地
        messageSource.setFallbackToSystemLocale(false);
        // 设置是否使用代码作为默认消息
        messageSource.setUseCodeAsDefaultMessage(messageSourceProperties.isUseCodeAsDefaultMessage());
        //设置国际化文件存储路径和名称    i18n目录，messages文件名
        String basename = messageSourceProperties.getBasename();
        if (basename == null || basename.isEmpty()) {
            throw new IllegalArgumentException("Basename cannot be null or empty");
        }
        messageSource.setBasename(basename);
        return messageSource;
    }

}
