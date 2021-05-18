package com.company.domain.hei;

import com.company.domain.inanimate.AcademicPosition;
import com.company.domain.people.Teacher;
import edu.emory.mathcs.backport.java.util.Collections;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FacultyIT {

    private final String NAME_F = "TEF";
    private final String NAME_T = "Brian Eno";
    private final AcademicPosition POSITION = AcademicPosition.ASPIRANT;

    Department department = Mockito.mock(Department.class);

    private Faculty faculty = new Faculty(NAME_F);

    @Test
    void findTeachersByPosition_findAnExistingTeacher_Equals() throws IOException {
        //GIVEN
        faculty.addDepartment(department);
        final List<Teacher> teachers = Collections.singletonList(
                new Teacher(NAME_T, POSITION));
        Mockito.doReturn(teachers).when(department).findTeachersByPosition(POSITION);

        //WHEN
        final List<Teacher> actual = department.findTeachersByPosition(POSITION);

        //THEN
        Mockito.verify(department).findTeachersByPosition(POSITION);
        assertEquals(actual, teachers);
    }
}