package com.heitian.ssm.service;

import com.heitian.ssm.model.SickContent;

import java.util.List;

/**
 * Created by Administrator on 2017/11/4.
 */
public interface DepartmentService {
    List<String> getDepartments();

    List<String> getDepartment(Integer num);

    SickContent getContents(Integer department_num,List<String>departments,List<String>department, Integer sick);
    List<String> getSicks(List<String> departments,Integer department);
}
