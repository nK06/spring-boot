package com.panther.demo.mapper;

import com.panther.demo.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeMapper {

    public Employee getEmployeeById(Integer id);

    public void insertEmp(Employee employee);

    public List<Employee> selectAll();

    public void updateEmp(Employee employee);

    public void deleteEmp(Integer id);
}
