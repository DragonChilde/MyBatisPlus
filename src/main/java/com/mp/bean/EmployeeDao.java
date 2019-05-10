package com.mp.bean;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.mp.bean.Employee;

public interface EmployeeDao {

    int insert(@Param("pojo") Employee pojo);

    int insertList(@Param("pojos") List< Employee> pojo);

    List<Employee> select(@Param("pojo") Employee pojo);

    int update(@Param("pojo") Employee pojo);

}
