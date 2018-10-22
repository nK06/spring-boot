package com.panther.demo.servicesImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panther.demo.entities.Employee;
import com.panther.demo.mapper.EmployeeMapper;
import com.panther.demo.services.EmployeeService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeMapper employeeMapper;

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeMapper.getEmployeeById(id);
    }

    @Override
    public void insertEmp(Employee employee) {
        employeeMapper.insertEmp(employee);
    }

    @Override
    public PageInfo<Employee> selectAll(Integer page, Integer size) {
        //开启分页查询，写在查询语句上方
        //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
        PageHelper.startPage(page, size);
        List<Employee> employeeList = employeeMapper.selectAll();
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList);
        return pageInfo;
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
    }

    @Override
    public void deleteEmp(Integer id) {
        employeeMapper.deleteEmp(id);
    }
}
