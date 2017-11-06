package com.heitian.ssm.model;

/**
 * Created by Administrator on 2017/11/2.
 */
public class Department {
    private Integer id;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departments='" + departments + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String departments;
    private String department;


    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
