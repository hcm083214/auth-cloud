package com.auth.cloud.i18n.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring上下文工具类
 *
 * @author 黄灿民
 * @date 2024/01/03
 */
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    @Override
    //设置Spring上下文
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringContextUtil.setApplicationContext()");
        //判断SpringContextUtil.applicationContext是否为空
        if (SpringContextUtil.applicationContext == null) {
            //如果为空，将applicationContext赋值给SpringContextUtil.applicationContext
            SpringContextUtil.applicationContext = applicationContext;
        }
    }
}
