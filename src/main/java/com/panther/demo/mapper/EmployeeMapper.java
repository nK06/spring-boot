package com.panther.demo.mapper;

import com.panther.demo.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> findAll();
}