package com.auth.cloud.common.utils;

import lombok.Data;

import java.util.Locale;

/**
 * 线程本地变量管理工具类
 *
 * @author 黄灿民
 * @date 2024/01/03
 */
public class ThreadLocalManagerUtil {

    @Data
    public static class HeaderInfo {
        String token;
        String language;
    }


    private static final ThreadLocal<HeaderInfo> THREAD_LOCAL = new ThreadLocal<>();

    public static String getLanguage() {
        return THREAD_LOCAL.get().getLanguage() == null ? Locale.getDefault().getLanguage() : THREAD_LOCAL.get().getLanguage();
    }

    public static String getToken() {
        return THREAD_LOCAL.get().getToken();
    }

    public static void add(HeaderInfo headerInfo) {
        THREAD_LOCAL.set(headerInfo);
    }

    public static void clear() {
        THREAD_LOCAL.remove();
    }
}
