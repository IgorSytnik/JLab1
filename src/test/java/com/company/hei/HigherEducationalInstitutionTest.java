package com.company.hei;

import com.company.exceptoins.EmptyListException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class HigherEducationalInstitutionTest {

    // for keyboard input
    String name = "My string";
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
    String n = "XX-00";
    HigherEducationalInstitution g1 = new HigherEducationalInstitution(n);
    HigherEducationalInstitution g2 = new HigherEducationalInstitution(n);
    HigherEducationalInstitution obj = new HigherEducationalInstitution("Tim Shaq");

    @Test
    void constructor_CompareNameAndString_Equals() throws IOException {
        System.setIn(in);

        HigherEducationalInstitution hei = new HigherEducationalInstitution();

        assertEquals(name, hei.getName());
        System.setIn(sysInBackup);
    }

    @Test
    void addFaculty_AddOne_True() throws IOException {
        System.setIn(in);

        assertTrue(obj.addFaculty());

        System.setIn(sysInBackup);
    }

    @Test
    void addFaculty_AddTwoEqualOnes_False() throws IOException {
        System.setIn(in);

        obj.addFaculty();
        assertFalse(obj.addFaculty());

        System.setIn(sysInBackup);
    }

    @Test
    void getFaculty_EmptyList_Null() {
        assertThrows(EmptyListException.class, ()->obj.getFaculty(0));
    }

    @Test
    void getFaculty_WrongNumber_Null() throws IOException {
        System.setIn(in);

        obj.addFaculty();

        System.setIn(sysInBackup);

        assertThrows(IndexOutOfBoundsException.class, ()->obj.getFaculty(4));
    }

    @Test
    void getFaculty_GetFacultyFromList_NotNull() throws IOException, EmptyListException {
        System.setIn(in);

        obj.addFaculty();

        System.setIn(sysInBackup);

        assertNotNull(obj.getFaculty(0));
    }

    @Test
    void getFacList_GetEmptyList_False() {
        assertFalse(obj.showFacList());
    }

    @Test
    void getFacList_GetNotEmptyList_True() throws IOException {
        System.setIn(in);

        obj.addFaculty();

        System.setIn(sysInBackup);

        assertTrue(obj.showFacList());
    }

//    @Test
//    void hashCode_CompareEqualHEIHashCodes_Equals() {
//        assertEquals(g1.hashCode(), g2.hashCode());
//        assertEquals(g1.hashCode(), g1.hashCode());
//    }
//
//    @Test
//    void hashCode_CompareNotEqualHEIHashCodes_NotEquals() {
//        assertNotEquals(obj.hashCode(), g1.hashCode());
//    }
//
//    @Test
//    void equals_CompareNotEqualHEIs_NotEquals() {
//        HashCodeTestClass O = new HashCodeTestClass();
//        O.hashcode = g2.hashCode();
//        assertFalse(g2.equals(O));
//        assertNotEquals(obj, g1);
//    }
//
//    @Test
//    void equals_CompareEqualHEIs_Equals() {
//        assertEquals(g1, g2);
//    }
}