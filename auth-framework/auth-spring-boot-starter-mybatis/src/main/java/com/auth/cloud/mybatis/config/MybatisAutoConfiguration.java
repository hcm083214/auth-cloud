package com.auth.cloud.mybatis.config;

import com.auth.cloud.mybatis.injector.SqlInjector;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@MapperScan(value = "${auth.info.mapper-base-package}")
public class MybatisAutoConfiguration {
    /**
     * 添加分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));//如果配置多个插件,切记分页最后添加
        return interceptor;
    }

    /**
     * 创建并返回一个InsertBatchSqlInjector实例。
     * 这个方法不接受任何参数。
     *
     * @return InsertBatchSqlInjector 返回一个InsertBatchSqlInjector的新实例，用于进行批量插入的SQL注入操作。
     */
    @Bean
    public SqlInjector sqlInjector() {
        return new SqlInjector();
    }
}
