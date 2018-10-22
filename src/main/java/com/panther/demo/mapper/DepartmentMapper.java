package com.panther.demo.mapper;

import com.panther.demo.entities.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

//指定是一个操作数据库的mapper
@Component
public interface DepartmentMapper {

    @Select("select *from department where id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int delDeptById(Integer id);

    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    public int updateDept(Department department);

    @Select("select *from department")
    public List<Department> selectAll();

}
