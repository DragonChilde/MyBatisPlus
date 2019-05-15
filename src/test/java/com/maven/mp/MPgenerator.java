package com.maven.mp;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.mp.bean.Teacher;
import com.mp.mapper.StudentMapper;
import com.mp.mapper.TeacherMapper;
import com.mp.service.TeacherService;
import org.junit.Test;
import org.omg.CORBA.IDLType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Lee
 * @create 2019/5/13 16:43
 */
public class MPgenerator {

    private ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");

    private TeacherMapper teacherMapper = applicationContext.getBean("teacherMapper", TeacherMapper.class);



    @Test
    public void tetGenerator(){
        //1. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setIdType(IdType.AUTO)// 主键策略
                    .setAuthor("Lee")// 作者
                    .setBaseColumnList(true)
                    .setActiveRecord(true)// 是否支持AR模式
                    .setOutputDir("D:\\Code\\MyBatisPlus\\src\\main\\java")// 生成路径
                    .setServiceName("%sService")// 设置生成的service接口的名字的首字母是否为I   // IEmployeeService
                    .setFileOverride(true)// 文件覆盖
                    .setBaseResultMap(true);


        //2. 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)// 设置数据库类型
                        .setDriverName("com.mysql.cj.jdbc.Driver")
                        .setUrl("jdbc:mysql://127.0.0.1:3306/mp?serverTimezone=GMT&useSSL=false&characterEncoding=utf-8")
                        .setUsername("root")
                        .setPassword("123456");

        //3. 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//全局大写命名
                        .setDbColumnUnderline(true)// 指定表名 字段名是否使用下划线
                        .setTablePrefix("tbl")
                        .setNaming(NamingStrategy.underline_to_camel)// 数据库表映射到实体的命名策略
                        .setInclude("tbl_teacher");// 生成的表

        //4. 包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setController("controller")
                        .setParent("com.mp")
                        .setMapper("mapper")
                        .setEntity("bean")
                        .setController("controller")
                        .setXml("mapper")
                        .setService("service");

        //5. 整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                     .setDataSource(dataSourceConfig)
                     .setPackageInfo(packageConfig)
                     .setStrategy(strategyConfig);
        //6. 执行
        autoGenerator.execute();
    }


    @Test
    public void testSelect(){
        Teacher teacher = teacherMapper.selectById(14);
        System.out.println(teacher);
    }
}
