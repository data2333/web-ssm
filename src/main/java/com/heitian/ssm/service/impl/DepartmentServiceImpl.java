package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.DepartmentDao;
import com.heitian.ssm.model.SickContent;
import com.heitian.ssm.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/4.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    DepartmentDao Department;


    public List<String> getDepartments() {
        return Department.getAllDepartments();
    }

    public List<String> getDepartment(Integer num) {
        return Department.getAllDepartment(num);
    }

    public SickContent getContents(Integer department_num, List<String> departments, List<String> department, Integer sick) {
        return Department.getContents(department.get(sick),departments.get(department_num));
    }

    public List<String> getSicks(List<String> departments,Integer department) {
        return Department.getSicks(departments.get(department));
    }
}
