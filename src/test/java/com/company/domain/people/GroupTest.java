package com.company.domain.people;

import com.company.exceptoins.EmptyListException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    int year = 3;
    String studentName = "Lan'Koma";
    Group obj = new Group("HH-11", year);

    @Test
    void addStudent_AddOne_True() {
        assertTrue(obj.addStudent(studentName));
    }

    @Test
    void addStudent_AddTwoEqualOnes_False() {
        obj.addStudent(studentName);
        assertFalse(obj.addStudent(studentName));
    }

    @Test
    void getStudent_EmptyList_Null() {
        assertThrows(EmptyListException.class, ()->obj.getStudent(0));
    }

    @Test
    void getStudent_WrongNumber_Null() {
        obj.addStudent(studentName);
        assertThrows(IndexOutOfBoundsException.class, ()->obj.getStudent(4));
    }

    @Test
    void getStudent_GetStudentFromList_NotNull() throws EmptyListException {
        obj.addStudent(studentName);
        assertNotNull(obj.getStudent(0));
    }

    @Test
    void showStudentsList_GetEmptyList_False() {
        assertFalse(obj.showStudentsList());
    }

    @Test
    void showStudentsList_GetNotEmptyList_True() {
        obj.addStudent(studentName);
        assertTrue(obj.showStudentsList());
    }
}