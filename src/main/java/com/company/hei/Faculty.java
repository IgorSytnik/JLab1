package com.company.hei;

import com.company.people.AcademicPosition;
import com.company.people.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean addDepartment(Department department) throws IOException {
        if(lookUp(department.getName())) {
            System.out.println("This faculty already has this department ");
            return false;
        } else {
            departments.add(department);
            return true;
        }
    }

    public boolean addDepartment() throws IOException {
        return addDepartment(new Department());
    }

    //
    public List<Teacher> findTeachersByPosition(AcademicPosition position) {
        return departments.stream().
                map(d -> d.findTeachersByPosition(position)).
                flatMap(Collection::stream).
                collect(Collectors.toList());
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
