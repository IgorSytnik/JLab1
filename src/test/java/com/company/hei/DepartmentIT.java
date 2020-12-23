package com.company.hei;

import com.company.people.AcademicPosition;
import com.company.people.Group;
import com.company.people.Teacher;
import edu.emory.mathcs.backport.java.util.Collections;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentIT {

    private final String NAME_G = "TT-11";
    private final int YEAR = 4;
    private final String NAME_T = "Brian Eno";
    private final AcademicPosition POSITION = AcademicPosition.ASPIRANT;

    Department department = Mockito.mock(Department.class);

    @Test
    void findGroupsByYear_() {
        //GIVEN
        final List<Group> groups = Collections.singletonList(
                new Group(NAME_G, YEAR));
        Mockito.doReturn(groups).when(department).findGroupsByYear(YEAR);

        //WHEN
        final List<Group> actual = department.findGroupsByYear(YEAR);

        //THEN
        assertEquals(actual, groups);

    }

    @Test
    void findTeachersByPosition() {
        //GIVEN
        final List<Teacher> teachers = Collections.singletonList(
                new Teacher(NAME_T, POSITION));
        Mockito.doReturn(teachers).when(department).findTeachersByPosition(POSITION);

        //WHEN
        final List<Teacher> actual = department.findTeachersByPosition(POSITION);

        //THEN
        assertEquals(actual, teachers);
    }
}