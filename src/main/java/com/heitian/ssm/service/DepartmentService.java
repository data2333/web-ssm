package com.heitian.ssm.service;

import com.heitian.ssm.model.SickContent;

import java.util.List;

/**
 * Created by Administrator on 2017/11/4.
 */
public interface DepartmentService {
    List<String> getDepartments();
    List<String> getDepartment(String Departments);
    SickContent getContents(Integer Department,Integer Sicks,Integer Content);
    List<String> getSicks(Integer Department,Integer Sick);
}
