package com.heitian.ssm.dao;

import com.heitian.ssm.model.Department;
import com.heitian.ssm.model.SickContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/11/3.
 */
public interface DepartmentDao {
    List<String>getAllDepartments();
    List<String>getAllDepartment(@Param("Departments")String Departments);
    List<String>getSicks(@Param("DepartmentName")String name);
    SickContent getContents(@Param("Department")String department,@Param("SickName")String name);
}
