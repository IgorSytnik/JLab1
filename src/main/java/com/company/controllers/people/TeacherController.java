package com.company.controllers.people;

import com.company.services.people.TeacherService;

public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
//        Assert.notNull(teacherService);
        this.teacherService = teacherService;
    }
}
