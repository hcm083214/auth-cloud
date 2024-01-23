package com.auth.cloud.i18n.config;


import com.auth.cloud.i18n.core.I18n;
import com.auth.cloud.i18n.utils.SpringContextUtil;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Bean;

/**
 * 国际化工具类
 *
 * @author 黄灿民
 * @date 2024/01/03
 */
public class I18nAutoConfiguration implements MessageSourceAware {
    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        // 设置MessageSource对象
        this.messageSource = messageSource;
    }

    @Deprecated
    private static class Lazy {
        // 使用懒加载方式实例化MessageSource对象
        private final MessageSource messageSource = SpringContextUtil.getBean(MessageSource.class);
    }

    @Bean
    public I18n i18n(){
        return new I18n(messageSource);
    }
}
