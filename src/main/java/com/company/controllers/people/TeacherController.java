package com.company.controllers.people;

import com.company.domain.people.Student;
import com.company.domain.people.Subject;
import com.company.services.interfaces.people.StudentService;
import com.company.services.interfaces.people.SubjectService;
import com.company.services.interfaces.people.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Map;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;

    public void giveGrades(Map<Student, Map<Date, Integer>> mapGrades, long subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        studentService.addGrades(mapGrades, subject);
    }

    public void giveAttestations(Map<Student, Boolean> mapAttest, long subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        studentService.addAttestations(mapAttest, subject);
    }
}
