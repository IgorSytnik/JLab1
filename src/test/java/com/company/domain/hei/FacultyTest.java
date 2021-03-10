package com.company.domain.hei;

import com.company.exceptoins.EmptyListException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacultyTest {

    /**
     * helping objects*/
    Faculty obj = new Faculty("Shaq");
    Department department = new Department("APEPS");

    @Test
    void getDepartmentList_GetEmptyList_False() {
        assertFalse(obj.showDepartmentList());
    }

    @Test
    void getDepartmentList_GetNotEmptyList_True() {
        obj.addDepartment(department);

        assertTrue(obj.showDepartmentList());
    }

    @Test
    void addDepartment_AddOne_True() {
        assertTrue(obj.addDepartment(department));
    }

    @Test
    void addDepartment_AddTwoEqualOnes_False() {
        obj.addDepartment(department);
        assertFalse(obj.addDepartment(department));

    }

    @Test
    void getDepartment_EmptyList_Null(){
        assertThrows(EmptyListException.class, ()->obj.getDepartment(0));
    }

    @Test
    void getDepartment_WrongNumber_Null() {
        obj.addDepartment(department);

        assertThrows(IndexOutOfBoundsException.class, ()->obj.getDepartment(4));
    }

    @Test
    void getDepartment_GetDepartmentFromList_NotNull() throws EmptyListException {
        obj.addDepartment(department);

        assertNotNull(obj.getDepartment(0));
    }
}