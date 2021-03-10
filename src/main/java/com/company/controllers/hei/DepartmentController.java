package com.company.controllers.hei;

import com.company.domain.people.AcademicPosition;
import com.company.domain.people.Group;
import com.company.domain.people.Teacher;
import com.company.services.hei.DepartmentService;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Map;

//@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
//        Assert.notNull(departmentService);
        this.departmentService = departmentService;
    }

    public List<Group> findGroupsByYear(int year) {
        throw new NotImplementedException("");
    }
    public int countStudentsByYear(int year) {
        throw new NotImplementedException("");
    }
    public Group maxStudentsInGroup() {
        throw new NotImplementedException("");
    }
    public double avgNumberOfStudents() {
        throw new NotImplementedException("");
    }
    public Map<Boolean, List<Group>> splitGroupsByYear(int year) {
        throw new NotImplementedException("");
    }
    public List<Teacher> findTeachersByPosition(AcademicPosition position) {
        throw new NotImplementedException("");
    }
    public Map<Boolean, List<Teacher>> splitTeachersByPosition(AcademicPosition position) {
        throw new NotImplementedException("");
    }
}
