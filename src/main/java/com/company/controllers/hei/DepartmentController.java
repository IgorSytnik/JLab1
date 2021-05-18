package com.company.controllers.hei;

import com.company.domain.inanimate.Group;
import com.company.domain.inanimate.subject.Grade;
import com.company.domain.inanimate.subject.ListHasStudents;
import com.company.domain.inanimate.subject.Subject;
import com.company.domain.people.Student;
import com.company.services.interfaces.people.GroupService;
import com.company.services.interfaces.people.StudentService;
import com.company.services.interfaces.people.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class DepartmentController {

//    @Autowired
    private final GroupService groupService;
//    @Autowired
    private final StudentService studentService;
//    @Autowired
    private final SubjectService subjectService;

    public Map<Student, List<Grade>> getGrates(long subjectId, long groupId) {
        Map<Student, List<Grade>> studentGrades = new HashMap<>();
        List<Student> students = groupService.getStudentsFromGroup(groupId);
        Subject subject = subjectService.getSubjectById(subjectId);

        for (Student student:
                students) {
            studentGrades.put(student,
                    studentService.getGrades(student, subject));
        }
        return studentGrades;
    }

    public Map<Student, List<ListHasStudents>> getAttestations(long subjectId, long groupId) {
        Map<Student, List<ListHasStudents>> studentGrades = new HashMap<>();
        List<Student> students = groupService.getStudentsFromGroup(groupId);
        Subject subject = subjectService.getSubjectById(subjectId);

        for (Student student:
                students) {
            studentGrades.put(student,
                    studentService.getAttestations(student, subject));
        }
        return studentGrades;
    }

    public void makeGroup(String name, int year) {
        groupService.makeGroup(new Group(name, year));
    }

    public List<Group> getAllGroups() {
        return groupService.getGroups();
    }

    public void makeStudent(String name, long groupId) {
        Group group = groupService.getGroupById(groupId);
        studentService.makeStudent(new Student(name, group));
    }

    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

}
