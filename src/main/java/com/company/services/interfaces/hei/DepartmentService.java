package com.company.services.interfaces.hei;

import com.company.domain.people.Student;

import java.util.List;

public interface DepartmentService {
    List<Student> getStudentsFromGroup(long groupId);
//    List<Group> findGroupsByYear(int year);
//    int countStudentsByYear(int year);
//    Group maxStudentsInGroup();
//    double avgNumberOfStudents();
//    Map<Boolean, List<Group>> splitGroupsByYear(int year);
//    List<Teacher> findTeachersByPosition(AcademicPosition position);
//    Map<Boolean, List<Teacher>> splitTeachersByPosition(AcademicPosition position);
}
