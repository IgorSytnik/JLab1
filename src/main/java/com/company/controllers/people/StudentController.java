package com.company.controllers.people;

import com.company.services.people.StudentService;

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
//        Assert.notNull(studentService);
        this.studentService = studentService;
    }
}
