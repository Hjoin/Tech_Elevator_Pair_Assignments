package com.techelevator;

public class Department {

    private String name;
    private int departmentId;


    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public int getDepartmentId() {
        return departmentId;
    }

    public Department(int departmentId, String name) {
        setDepartmentId(departmentId);
        setName(name);
    }
}
