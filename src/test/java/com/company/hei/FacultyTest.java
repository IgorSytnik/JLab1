package com.company.hei;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class FacultyTest {

    // for keyboard input
    String expected = "My@@ string\n" +
            "My string.\n" +
            "My string\n" +
            "My string\n" +
            "n\n" +
            "My string\n" +
            "y\n";
    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in = new ByteArrayInputStream(expected.getBytes());

    // helping objects
    String name = "Tim Shaq";
    Faculty s1 = new Faculty(name);
    Faculty s2 = new Faculty(name);
    Faculty obj = new Faculty("Shaq");

    @Test
    void getDepartmentList_GetEmptyList_False() {
        assertFalse(obj.getDepartmentList());
    }

    @Test
    void getDepartmentList_GetNotEmptyList_True() throws IOException {
        System.setIn(in);

        obj.addDepartment();

        System.setIn(sysInBackup);

        assertTrue(obj.getDepartmentList());
    }

    @Test
    void addDepartment_AddOne_True() throws IOException {
        System.setIn(in);

        assertTrue(obj.addDepartment());

        System.setIn(sysInBackup);
    }

    @Test
    void addDepartment_AddTwoEqualOnes_False() throws IOException {
        System.setIn(in);

        obj.addDepartment();
        assertFalse(obj.addDepartment());

        System.setIn(sysInBackup);
    }

    @Test
    void getDepartment_EmptyList_Null(){
        assertNull(obj.getDepartment(0));
    }

    @Test
    void getDepartment_WrongNumber_Null() throws IOException {
        System.setIn(in);

        obj.addDepartment();

        System.setIn(sysInBackup);

        assertNull(obj.getDepartment(4));
    }

    @Test
    void getDepartment_GetDepartmentFromList_NotNull() throws IOException {
        System.setIn(in);

        obj.addDepartment();

        System.setIn(sysInBackup);

        assertNotNull(obj.getDepartment(0));
    }

//    @Test
//    void hashCode_CompareEqualFacultiesHashCodes_Equals() {
//        assertEquals(s1.hashCode(), s2.hashCode());
//        assertEquals(s1.hashCode(), s1.hashCode());
//    }
//
//    @Test
//    void hashCode_CompareNotEqualFacultiesHashCodes_NotEquals() {
//        assertNotEquals(obj.hashCode(), s1.hashCode());
//    }
//
//    @Test
//    void equals_CompareNotEqualFaculties_NotEquals() {
//        HashCodeTestClass O = new HashCodeTestClass();
//        O.hashcode = s2.hashCode();
//        assertFalse(s2.equals(O));
//        assertNotEquals(obj, s1);
//    }
//
//    @Test
//    void equals_CompareEqualFaculties_Equals() {
//        assertEquals(s1, s2);
//    }
}