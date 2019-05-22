package com.mp.metaObjectHandler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author Lee
 * @create 2019/5/20 14:08
 */
/**
 * 自定义公共字段填充处理器
 */
public class MyMetaObjectHandler extends MetaObjectHandler {
    /**
     * 插入操作 自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object fieldValByName = getFieldValByName("last_name", metaObject);
        if (fieldValByName == null){
            System.out.println("=========meta object handler insert fill===========");
            setFieldValByName("last_name","test1",metaObject);
        }

    }

    /**
     * 修改操作 自动填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {

        Object fieldValByName = getFieldValByName("last_name", metaObject);
        if (fieldValByName == null){
            System.out.println("=========meta object handler update fill===========");
            setFieldValByName("last_name","test2",metaObject);
        }
    }
}
