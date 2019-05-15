package com.maven.mp;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mp.bean.Student;
import com.mp.mapper.EmployeeMapper;
import com.mp.mapper.StudentMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Lee
 * @create 2019/5/13 14:07
 */
public class MPARTest {
    private ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
    //注：虽然AR模式用不到该接口，但是一定要定义，否则使用AR时会报空指针异常。
//    private StudentMapper studentMapper = applicationContext.getBean("studentMapper", StudentMapper.class);

    @Test
    public void testARPage(){
        Student student = new Student();
        Page<Student> page = student.selectPage(new Page<Student>(1, 2), new EntityWrapper<Student>().eq("gender", 0));
        List<Student> studentList = page.getRecords();
        System.out.println(studentList);
    }

    /**
     * AR 删除操作
     *
     * 注意: 删除不存在的数据 逻辑上也是属于成功的.
     */
    @Test
    public void testARDelete(){
        Student student = new Student();
//        boolean result = student.deleteById(15);
//        student.setId(15);
//        boolean result = student.deleteById();
        boolean result = student.delete(new EntityWrapper<Student>().eq("id", 5));
        System.out.println(result);
    }

    @Test
    public void testARSelect(){
        Student student = new Student();
//        Student stu = student.selectById(15);
//        student.setId(15);
//        Student stu = student.selectById();
//        List<Student> stu = student.selectAll();
//        List<Student> stu = student.selectList(new EntityWrapper<Student>().eq("last_name", "C"));
        int count = student.selectCount(Condition.create());
        System.out.println(count);


    }

    @Test
    public void testARUpdate(){
        Student student = new Student();
        student.setId(15);

        student.setAge(6);
        boolean update = student.updateById();
        System.out.println(update);
    }

    @Test
    public void testARInsert(){
        Student student = new Student();
        student.setLastName("C");
        student.setEmail("c@c.com");
        student.setGender(1);
        student.setAge(12);

        boolean b = student.insert();
        System.out.println(b);
    }
}
