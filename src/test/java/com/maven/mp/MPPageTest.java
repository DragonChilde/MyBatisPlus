package com.maven.mp;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.mp.bean.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Lee
 * @create 2019/5/14 15:41
 */
public class MPPageTest {
    private ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper = applicationContext.getBean("employeeMapper",EmployeeMapper.class);

    @Test
    public void testOptimisticLocker(){
        Employee employee = new Employee();
        employee.setId(14);
        employee.setLastName("B");
        employee.setVersion(2);
        employeeMapper.updateById(employee);
    }

    @Test
    public void testUpdate(){
        Employee employee = new Employee();
        employee.setLastName("A");
        employee.setEmail("a@a.com");
        employee.setGender(1);
        employee.setAge(1);
        employeeMapper.insert(employee);
    }

    @Test
    public void testDelete(){
        employeeMapper.delete(null);
    }

    @Test
    public void testPage(){
        Page<Employee> page = new Page<Employee>(0, 1);

        List list = employeeMapper.selectPage(page, null);
        System.out.println(list);

        System.out.println("=======================");
        System.out.println("总条数:" +page.getTotal());
        System.out.println("当前页码: "+  page.getCurrent());
        System.out.println("总页码:" + page.getPages());
        System.out.println("每页显示的条数:" + page.getSize());
        System.out.println("是否有上一页: " + page.hasPrevious());
        System.out.println("是否有下一页: " + page.hasNext());

        //将查询的结果封装到page对象中
        page.setRecords(list);
    }
}
