package com.panther.demo.controller;

import com.panther.demo.entities.Department;
import com.panther.demo.services.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @GetMapping("dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("dept")
    public Department insertDepartment(Department department){
        departmentService.insertDepartment(department);
        return department;
    }

}
