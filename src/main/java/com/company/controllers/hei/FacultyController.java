package com.company.controllers.hei;

import com.company.domain.hei.Department;
import com.company.domain.hei.Faculty;
import com.company.domain.inanimate.Group;
import com.company.domain.inanimate.subject.Grade;
import com.company.domain.inanimate.subject.ListHasStudents;
import com.company.domain.inanimate.subject.Subject;
import com.company.domain.people.Student;
import com.company.services.interfaces.hei.DepartmentService;
import com.company.services.interfaces.hei.FacultyService;
import com.company.services.interfaces.people.GroupService;
import com.company.services.interfaces.people.StudentService;
import com.company.services.interfaces.people.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class FacultyController {

//    @Autowired
    private final GroupService groupService;
//    @Autowired
    private final StudentService studentService;
//    @Autowired
    private final SubjectService subjectService;

    private final FacultyService facultyService;

    private final DepartmentService departmentService;

    public void makeFaculty(String name) {
        facultyService.makeFaculty(new Faculty(name));
    }

    public List<Faculty> getAllFaculties() {
        return facultyService.getFaculties();
    }

    public void deleteAllFaculties() {
        facultyService.deleteAll();
    }

//    public void makeDepartment(String name, long facultyId) {
//        Faculty faculty = facultyService.getFacultyById(facultyId);
//        departmentService.makeDepartment(new Department(name, faculty));
//    }

}
