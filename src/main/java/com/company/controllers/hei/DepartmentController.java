package com.company.controllers.hei;

import com.company.domain.people.Student;
import com.company.domain.people.Subject;
import com.company.services.hei.DepartmentService;
import com.company.services.people.GroupService;
import com.company.services.people.StudentService;
import com.company.services.people.SubjectService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
public class DepartmentController {

    private final GroupService groupService;
    private final StudentService studentService;
    private final SubjectService subjectService;


    public DepartmentController(GroupService groupService, StudentService studentService, SubjectService subjectService) {
//        Assert.notNull(departmentService); //Spring
        this.groupService = groupService;
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    public void giveGrades(Map<Student, Map<Date, Integer>> mapGrades, long subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        studentService.addGrades(mapGrades, subject);
    }

    public void giveAttestations(Map<Student, Boolean> mapAttest, long subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        studentService.addAttestations(mapAttest, subject);
    }

    public Map<Student, Map<Date, Integer>> getGrates(long subjectId, long groupId) {
        Map<Student, Map<Date,Integer>> studentGrades = new HashMap<>();
        List<Student> students = groupService.getStudentsFromGroup(groupId);
        Subject subject = subjectService.getSubjectById(subjectId);

        for (Student student:
                students) {
            studentGrades.put(student,
                    studentService.getGrades(student, subject));
        }
        return studentGrades;
    }

    public Map<Student, boolean[]> getAttestations(long subjectId, long groupId)  {
        Map<Student, boolean[]> studentGrades = new HashMap<>();
        List<Student> students = groupService.getStudentsFromGroup(groupId);
        Subject subject = subjectService.getSubjectById(subjectId);

        for (Student student:
                students) {
            studentGrades.put(student,
                    studentService.getAttestations(student, subject));
        }
        return studentGrades;
    }

}
