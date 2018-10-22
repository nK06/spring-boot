package com.panther.demo.services;

import com.github.pagehelper.PageInfo;
import com.panther.demo.entities.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface EmployeeService {

    public Employee getEmployeeById(Integer id);

    public void insertEmp(Employee employee);

    public PageInfo<Employee> selectAll(Integer page,Integer size);

    public void updateEmp(Employee employee);

    public void deleteEmp(Integer id);
}
