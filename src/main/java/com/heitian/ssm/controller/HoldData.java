package com.heitian.ssm.controller;

import java.util.List;

/**
 * Created by Administrator on 2017/11/5.
 */
public class HoldData {
    private List departments;
    private List department;
    private List sick_name;
    private List<String> parts_name;
    private List<String> sicks_in_parts;


    public List<String> getSicks_in_parts() {
        return sicks_in_parts;
    }

    public void setSicks_in_parts(List<String> sicks_in_parts) {
        this.sicks_in_parts = sicks_in_parts;
    }

    public List<String> getParts_name() {
        return parts_name;
    }

    public void setParts_name(List<String> parts_name) {
        this.parts_name = parts_name;
    }

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
