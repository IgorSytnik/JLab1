package com.company.controllers.hei;

import com.company.domain.people.Student;
import com.company.domain.people.Subject;
import com.company.services.interfaces.people.GroupService;
import com.company.services.interfaces.people.StudentService;
import com.company.services.interfaces.people.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DepartmentController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;

//    public DepartmentController(@NonNull GroupService groupService,
//                                @NonNull StudentService studentService,
//                                @NonNull SubjectService subjectService) {
////        Assert.notNull(groupService, groupService.getClass().getName()); //Spring
//        this.groupService = groupService;
//        this.studentService = studentService;
//        this.subjectService = subjectService;
//    }

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

    public Map<Student, boolean[]> getAttestations(long subjectId, long groupId) {
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
