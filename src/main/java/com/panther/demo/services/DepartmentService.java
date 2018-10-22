package com.panther.demo.services;

import com.panther.demo.entities.Department;

import java.util.List;

public interface DepartmentService {

    public Department getDepartmentById(Integer id);

    public void insertDepartment(Department department);

    public void updateDepartment(Department department);

    public void deleteDepartment(Integer id);

    public List<Department> selectAll();

}
