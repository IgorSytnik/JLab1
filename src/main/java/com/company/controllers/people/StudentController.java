package com.company.controllers.people;

import com.company.domain.inanimate.Group;
import com.company.domain.inanimate.subject.Work;
import com.company.domain.people.Student;
import com.company.services.interfaces.people.GroupService;
import com.company.services.interfaces.people.StudentService;
import com.company.services.interfaces.people.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class StudentController {
//    @Autowired
    private final StudentService studentService;
//    @Autowired
    private final GroupService groupService;
//    @Autowired
    private final WorkService workService;

    public List<Work> getWorks(long groupId) {
        Group group = groupService.getGroupById(groupId);
        return group.getWorks();
    }

    public boolean handOverWork(long studentId, long workId, String file) {
        Student student = studentService.getStudentById(studentId);
        Work work = workService.getWorkById(workId);
        return studentService.handOverWork(work, file, student);
    }
}