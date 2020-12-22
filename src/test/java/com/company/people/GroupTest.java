package com.company.people;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    int num = 1;
    String expected =
            "-2\n" +
                    "n\n" +
                    "0\n" +
                    "n\n" +
                    "FMA\n" +
                    "2\n" +
                    "n\n" +
                    num + "\n" +
                    "y\n";
    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in = new ByteArrayInputStream(expected.getBytes());


    String group = "XX-00";
    int year = 3;
    Group g1 = new Group(group, year);
    Group g2 = new Group(group, year);
    Group obj = new Group("HH-11", year);


    @Test
    void constructor_CompareNameAndString_Equals() throws IOException {
        String name1 = "XX-11";
        int num1 = 1;
        String expected1 =
                "p34-123\n" +
                        "12-yu\n" +
                        "XX-00\n" +
                        "n\n" +
                        name1 + "\n" +
                        "y\n" +
                        "2\n" +
                        "n\n" +
                        num1 + "\n" +
                        "y\n";
        ByteArrayInputStream in1 = new ByteArrayInputStream(expected1.getBytes());
        System.setIn(in1);

        Group obj1 = new Group();

        assertEquals(name1 + ", year: " + num1, obj1.toString());
        System.setIn(sysInBackup);
    }


    @Test
    void addStudent_AddOne_True() throws IOException {
        System.setIn(in);

        assertTrue(obj.addStudent());

        System.setIn(sysInBackup);
    }

    @Test
    void addStudent_AddTwoEqualOnes_False() throws IOException {
        System.setIn(in);

        obj.addStudent();
        assertFalse(obj.addStudent());

        System.setIn(sysInBackup);
    }

    @Test
    void getStudent_EmptyList_Null() {
        assertNull(obj.getStudent(0));
    }

    @Test
    void getStudent_WrongNumber_Null() throws IOException {
        System.setIn(in);

        obj.addStudent();

        System.setIn(sysInBackup);

        assertNull(obj.getStudent(4));
    }

    @Test
    void getStudent_GetDepartmentFromList_NotNull() throws IOException {
        System.setIn(in);

        obj.addStudent();

        System.setIn(sysInBackup);

        assertNotNull(obj.getStudent(0));
    }

    @Test
    void showStudentsList_GetEmptyList_False() {
        assertFalse(obj.showStudentsList());
    }

    @Test
    void showStudentsList_GetNotEmptyList_True() throws IOException {
        System.setIn(in);

        obj.addStudent();

        System.setIn(sysInBackup);

        assertTrue(obj.showStudentsList());
    }

//    @Test
//    void getYear_CompareYearAndVar_Equals() {
//        assertEquals(year, g1.getYear());
//    }
//
//    @Test
//    void toString_CompareEqualNames_Equals() {
//        assertEquals(group + ", year: " + year, g1.toString());
//        assertEquals(g2.toString(), g1.toString());
//        assertEquals(g1.toString(), g1.toString());//
//    }
//
//    @Test
//    void toString_CompareNonEqualNames_NotEquals() {
//        assertNotEquals(obj.toString(), g1.toString());
//    }
//
//    @Test
//    void hashCode_CompareEqualGroupHashCodes_Equals() {
//        assertEquals(g1.hashCode(), g2.hashCode());
//        assertEquals(g1.hashCode(), g1.hashCode());
//    }
//
//    @Test
//    void hashCode_CompareNotEqualGroupHashCodes_NotEquals() {
//        assertNotEquals(obj.hashCode(), g1.hashCode());
//    }
//
//    @Test
//    void equals_CompareNotEqualGroups_NotEquals() {
//        HashCodeTestClass O = new HashCodeTestClass();
//        O.hashcode = g2.hashCode();
//        assertFalse(g2.equals(O));
//        assertNotEquals(obj, g1);
//    }
//
//    @Test
//    void equals_CompareEqualGroups_Equals() {
//        assertEquals(g1, g2);
//    }
}