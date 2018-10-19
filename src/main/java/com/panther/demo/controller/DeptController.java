package com.panther.demo.controller;

import com.panther.demo.entities.Department;
import com.panther.demo.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("dept")
    public Department insertDepartment(Department department){
        departmentMapper.insertDept(department);
        return department;
    }
}
