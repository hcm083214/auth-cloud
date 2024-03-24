package com.auth.cloud.i18n.config;


import com.auth.cloud.i18n.core.I18n;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Bean;

/**
 * 国际化工具类
 *
 * @author 黄灿民
 * @date 2024/01/03
 */
@AutoConfiguration
public class I18nAutoConfiguration implements MessageSourceAware, ApplicationContextAware {
    private MessageSource messageSource;
    private static ApplicationContext applicationContext = null;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        // 设置MessageSource对象
        this.messageSource = messageSource;
    }

    @Override
    //设置Spring上下文
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //判断SpringContextUtil.applicationContext是否为空
        if (I18nAutoConfiguration.applicationContext == null) {
            //如果为空，将applicationContext赋值给SpringContextUtil.applicationContext
            I18nAutoConfiguration.applicationContext = applicationContext;
        }
    }
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
    @Bean
    public I18n i18n(){
        return new I18n(messageSource);
    }
}
