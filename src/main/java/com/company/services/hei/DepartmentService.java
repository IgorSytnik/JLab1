package com.company.services.hei;

import com.company.domain.people.AcademicPosition;
import com.company.domain.people.Group;
import com.company.domain.people.Teacher;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<Group> findGroupsByYear(int year);
    int countStudentsByYear(int year);
    Group maxStudentsInGroup();
    double avgNumberOfStudents();
    Map<Boolean, List<Group>> splitGroupsByYear(int year);
    List<Teacher> findTeachersByPosition(AcademicPosition position);
    Map<Boolean, List<Teacher>> splitTeachersByPosition(AcademicPosition position);
}