package com.company.services.interfaces.hei;

import com.company.domain.hei.Faculty;
import com.company.domain.inanimate.Group;
import com.company.domain.people.Student;

import java.util.List;

public interface FacultyService {
    Faculty getFacultyById(long facultyId);
    void makeFaculty(Faculty faculty);
    List<Faculty> getFaculties();
    void deleteAll();
}
