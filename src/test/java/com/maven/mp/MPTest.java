package com.maven.mp;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mp.bean.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.*;

/**
 * @author Lee
 * @create 2019-05-07 23:04
 */
public class MPTest {
      private ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
      private EmployeeMapper employeeMapper = applicationContext.getBean("employeeMapper",EmployeeMapper.class);


      @Test
      public void testEntityWrapperSelect(){
          List page = employeeMapper.selectPage(new Page<Employee>(2, 2),
                  new EntityWrapper()
                  .between("age", 20, 50)
                  .eq("last_name","Tome")
                  .eq("gender",1)
          );
          System.out.println(page);
      }
    /**
     * 通用 删除操作
     */
      @Test
      public void testDelete(){
          //1 .根据id进行删除
//          Integer integer = employeeMapper.deleteById(11);
//          System.out.println(integer);
//          HashMap<String,Object> map = new HashMap();
//          map.put("last_name","test");
//          map.put("age",12);

          //2. 根据 条件进行删除
//          Integer integer = employeeMapper.deleteByMap(map);
//          System.out.println(integer);

          ArrayList<Integer> list = new ArrayList();
          list.add(9);
          //3. 批量删除
          Integer ids = employeeMapper.deleteBatchIds(list);
          System.out.println(ids);
      }

    /**
     * 通用 查询操作
     */
      @Test
      public void testSelect(){
          //1. 通过id查询
//          Employee employee = employeeMapper.selectById(10);
//          System.out.println(employee.getLastName());

          Employee e = new Employee();
          e.setGender(0);
          e.setAge(10);
          //2. 通过多个列进行查询
          //selectOne只可以取数据唯一一条，获取到多条会报异常
          Employee selectOne = employeeMapper.selectOne(e);
          System.out.println(selectOne.getLastName());


          ArrayList<Integer> list = new ArrayList();
          list.add(1);
          list.add(2);
          //3. 通过多个id进行查询    <foreach>
          List<Employee> employees = employeeMapper.selectBatchIds(list);
//          for (int i = 0; i < employees.size(); i++) {
//              System.out.println(employees.get(i).getLastName());
//
//          }

          HashMap<String, Object> map = new HashMap();
          map.put("last_name","test"); //注意这里的KEY指的是数据库字段名
          map.put("age",12);
          //4. 通过Map封装条件查询
          List<Employee> selectByMap = employeeMapper.selectByMap(map);
//          ListIterator<Employee> employeeListIterator = selectByMap.listIterator();
//          while (employeeListIterator.hasNext())
//          {
//              System.out.println(employeeListIterator.next().getId());
//          }

          //5. 分页查询
          List<Employee> list2 = employeeMapper.selectPage(new Page(3, 2), null);
          System.out.println(list2);

      }

    /**
     * 通用 更新操作
     */
      @Test
      public void testUpdate(){
          Employee employee = new Employee();
          employee.setId(10);
          employee.setLastName("test10");
//          employee.setEmail("test10@test10.com");
          employee.setAge(10);
          employee.setGender(0);
//          Integer id = employeeMapper.updateById(employee);
          Integer id = employeeMapper.updateAllColumnById(employee);
          System.out.println(id);
      }

    /**
     * 通用 插入操作
     */
      @Test
      public void testInsert(){
          Employee employee = new Employee();
          employee.setLastName("test");
//          employee.setAge(12);
//          employee.setEmail("test@test.com");
//          employee.setGender(1);
          employee.setSalary(20000);
          //插入到数据库
          // insert方法在插入时， 会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到SQL语句中
//          Integer integer = employeeMapper.insert(employee);

          //insertAllColumn方法在插入时， 不管属性是否非空， 属性所对应的字段都会出现到SQL语句中.
         employeeMapper.insertAllColumn(employee);

         //System.out.println("result: "+integer);
        //获取当前数据在数据库中的主键值
          Integer key = employee.getId();
          System.out.println(key);
      }

    @Test
    public void dataSourceTest() throws Exception{
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
