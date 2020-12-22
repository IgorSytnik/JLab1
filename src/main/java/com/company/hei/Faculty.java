package com.company.hei;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Faculty extends Institution {
    private List<Department> departments = new ArrayList<>();

    public Faculty() throws IOException {
        this.name = this.enterName();
    }

    public Faculty(String n) {
        this.name = n;
    }

    private boolean lookUp(final String obName) {
        return departments.stream().anyMatch(o -> o.getName().equals(obName));
    }

    public boolean addDepartment() throws IOException {
        Department department = new     Department();
        if(lookUp(department.getName())) {
            System.out.println("This faculty already has this department ");
            return false;
        } else {
            departments.add(department);
            return true;
        }
    }

    public boolean getDepartmentList() {
        return getList(departments, "departments");
    }
    public Department getDepartment(int i) {
        return (Department) getOne(departments, "departments", i);
    }

    @Override
        public int hashCode() {
        return name.hashCode() + departments.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Faculty) {
            Faculty anobj = (Faculty)obj;
            return this.name.equals(anobj.name) & this.departments.equals(anobj.departments);
        }
        return false;
    }
}
