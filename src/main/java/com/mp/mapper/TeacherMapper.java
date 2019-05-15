package com.mp.mapper;

import com.mp.bean.Teacher;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lee
 * @since 2019-05-13
 */
public interface TeacherMapper extends BaseMapper<Teacher> {

    void deleteAll();
}
