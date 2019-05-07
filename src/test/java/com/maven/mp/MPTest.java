package com.maven.mp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author Lee
 * @create 2019-05-07 23:04
 */
public class MPTest {
      ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void dataSourceTest() throws Exception{
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
