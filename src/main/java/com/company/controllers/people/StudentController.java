package com.company.controllers.people;

import com.company.domain.people.Group;
import com.company.domain.people.Student;
import com.company.domain.people.Work;
import com.company.services.interfaces.people.GroupService;
import com.company.services.interfaces.people.StudentService;
import com.company.services.interfaces.people.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private WorkService workService;

    public List<Work> getWorkTerms(long groupId) {
        Group group = groupService.getGroupById(groupId);
        return groupService.getWorks(group);
    }
    public String handOverWork(long studentId, long workId, String file) {
        Student student = studentService.getStudentById(studentId);
        Work work = workService.getWorkById(workId);
        return studentService.handOverWork(work, file, student);
    }
}