package com.auth.cloud.mybatis.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;

import java.util.List;

public class SqlInjector extends DefaultSqlInjector {
    /**
     * 获取方法列表。
     * 该方法会从给定的映射器类和表信息中获取方法列表，并在列表中添加一个新的插入批量某些列的方法。
     *
     * @param mapperClass 映射器类，用于获取与表信息相关的方法列表。
     * @param tableInfo 表信息，包含关于数据库表的结构和元数据。
     * @return 返回包含所有映射方法的列表，其中包括默认方法和新增的插入批量某些列的方法。
     */
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        methodList.add(new InsertBatchSomeColumn());
        return methodList;
    }
}
