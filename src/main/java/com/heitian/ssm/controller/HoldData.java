package com.heitian.ssm.controller;

import java.util.List;

/**
 * Created by Administrator on 2017/11/5.
 */
public class HoldData {
    private List departments;
    private List department;
    private List sick_name;

    public List getDepartments() {
        return departments;
    }

    public void setDepartments(List departments) {
        this.departments = departments;
    }

    public List getDepartment() {
        return department;
    }

    public void setDepartment(List department) {
        this.department = department;
    }

    public List getSick_name() {
        return sick_name;
    }

    public void setSick_name(List sick_name) {
        this.sick_name = sick_name;
    }
}
