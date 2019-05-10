package com.mp.bean;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.mp.bean.Employee;
import com.mp.bean.EmployeeDao;

@Service
public class EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

    public int insert(Employee pojo){
        return employeeDao.insert(pojo);
    }

    public int insertList(List< Employee> pojos){
        return employeeDao.insertList(pojos);
    }

    public List<Employee> select(Employee pojo){
        return employeeDao.select(pojo);
    }

    public int update(Employee pojo){
        return employeeDao.update(pojo);
    }

}
