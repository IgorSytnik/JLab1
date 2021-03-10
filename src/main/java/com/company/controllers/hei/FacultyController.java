package com.company.controllers.hei;

import com.company.services.hei.FacultyService;

public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
//        Assert.notNull(facultyService);
        this.facultyService = facultyService;
    }
}
