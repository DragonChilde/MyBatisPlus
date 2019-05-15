package com.mp.injector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * @author Lee
 * @create 2019/5/14 17:49
 */
public class MyInjector extends AutoSqlInjector {
    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
       // super.inject(configuration, builderAssistant, mapperClass, modelClass, table);

        teacherDeleteAll(configuration, builderAssistant, mapperClass, modelClass, table);

    }

    private void teacherDeleteAll(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table){

        String sql ="delete from "+table.getTableName();
        String method = "deleteAll";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

        //this.addMappedStatement(mapperClass, method, sqlSource, SqlCommandType.DELETE, Integer.class);
        this.addDeleteMappedStatement(mapperClass,method,sqlSource);
    }
}
