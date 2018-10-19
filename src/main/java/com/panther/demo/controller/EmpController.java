package com.panther.demo.controller;

import com.panther.demo.dao.DepartmentDao;
import com.panther.demo.dao.EmployeeDao;
import com.panther.demo.entities.Department;
import com.panther.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;
    /**
     * 查询所有员工返回列表页
     * @return
     */
    @GetMapping("/emps")
    public String empList(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
     * 新增员工页面
     * @return
     */
    @GetMapping("/emp")
    public String addEmpForm(Model model){
        //查询出所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "/emp/addEmp";
    }

    /**
     * 新增员工方法 ResetFul方式 采用post请求
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee,Model model){

        employeeDao.save(employee);
        //redirect:重定向到一个地址
        //forward:转发请求到一个地址
        return "redirect:/emps";
    }

    /**
     * 修改方法
     */
    @GetMapping("/emp/{id}")
    public String modifyEmp(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        //显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        //复用增加页面
        return "/emp/addEmp";
    }

    /**
     * 修改员工信息  ResetFul方式 采用put请求
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除员工信息
     * @param id
     * @return
     */
    @DeleteMapping("emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
