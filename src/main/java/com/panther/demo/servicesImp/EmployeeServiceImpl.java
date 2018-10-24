package com.panther.demo.servicesImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panther.demo.entities.Employee;
import com.panther.demo.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl{

    private EmployeeMapper employeeMapper;

    public Employee getEmployeeById(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    public void insertEmp(Employee employee) {
        employeeMapper.insert(employee);
    }

    public PageInfo<Employee> selectAll(Integer page, Integer size) {
        //开启分页查询，写在查询语句上方
        //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
        PageHelper.startPage(page, size);
        List<Employee> employeeList = employeeMapper.findAll();
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList);
        return pageInfo;
    }

    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }
}
