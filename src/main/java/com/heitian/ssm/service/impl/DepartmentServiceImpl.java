package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.DepartmentDao;
import com.heitian.ssm.model.Department;
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
    DepartmentDao dao;


    public List<String> getDepartments() {
        return dao.getAllDepartments();
    }

    public List<String> getDepartment(String Departments) {
        return dao.getAllDepartment(Departments);
    }

    public SickContent getContents(Integer Department,Integer Sicks,Integer Content) {
        String departments=dao.getAllDepartments().get(Department);
        String department=dao.getAllDepartment(departments).get(Sicks);
        String content=dao.getSicks(department).get(Content);
//        String value, String SickName
        return dao.getContents(department,content);
    }

    public List<String> getSicks(Integer Department,Integer Sick) {
        String departments=dao.getAllDepartments().get(Department);
        String department=dao.getAllDepartment(departments).get(Sick);
        return dao.getSicks(department);
    }
}
