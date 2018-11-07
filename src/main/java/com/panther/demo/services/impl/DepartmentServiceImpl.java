package com.panther.demo.services.impl;

import com.panther.demo.entities.Department;
import com.panther.demo.mapper.DepartmentMapper;
import com.panther.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @Override
    public void insertDepartment(Department department) {
        departmentMapper.insertDept(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDept(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentMapper.delDeptById(id);
    }

    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }
}
