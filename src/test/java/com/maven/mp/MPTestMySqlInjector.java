package com.maven.mp;

import com.mp.bean.Student;
import com.mp.mapper.EmployeeMapper;
import com.mp.mapper.StudentMapper;
import com.mp.mapper.TeacherMapper;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Lee
 * @create 2019/5/14 18:01
 */
public class MPTestMySqlInjector {
    private ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
    private TeacherMapper teacherMapper = applicationContext.getBean("teacherMapper", TeacherMapper.class);
    private StudentMapper studentMapper = applicationContext.getBean("studentMapper", StudentMapper.class);

    @Test
    public void testLogicSqlInject(){
//        Integer result = studentMapper.deleteById(14);
//        System.out.println(result);
        Student student = studentMapper.selectById(14);
        System.out.println(student);
    }

    @Test
    public void testMySqlInjector(){
        teacherMapper.deleteAll();
    }
}
