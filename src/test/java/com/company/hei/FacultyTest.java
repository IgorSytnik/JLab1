package com.company.hei;

import com.company.exceptoins.EmptyListException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacultyTest {

    // for keyboard input
//    String expected = "My@@ string\n" +
//            "My string.\n" +
//            "My string\n" +
//            "My string\n" +
//            "n\n" +
//            "My string\n" +
//            "y\n";
//    InputStream sysInBackup = System.in; // backup System.in to restore it later
//    ByteArrayInputStream in = new ByteArrayInputStream(expected.getBytes());

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