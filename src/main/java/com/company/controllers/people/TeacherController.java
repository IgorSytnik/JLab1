package com.company.controllers.people;

import com.company.domain.inanimate.subject.Grade;
import com.company.domain.inanimate.subject.Subject;
import com.company.domain.people.Student;
import com.company.services.interfaces.people.StudentService;
import com.company.services.interfaces.people.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class TeacherController {

//    @Autowired
//    private final TeacherService teacherService;
//    @Autowired
    private final StudentService studentService;
//    @Autowired
    private final SubjectService subjectService;

    public void giveGrades(Map<Student, List<Grade>> mapGrades, long subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        studentService.addGrades(mapGrades, subject);
    }

    public void giveAttestations(Map<Student, Boolean> mapAttest, long subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        studentService.addAttestations(mapAttest, subject);
    }
}
