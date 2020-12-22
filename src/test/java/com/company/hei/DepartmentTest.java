package com.company.hei;

import com.company.people.AcademicPosition;
import com.company.people.Group;
import com.company.people.Teacher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

/* for keyboard input */
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
    int num2 = 1;
    String expected2 =
            "-2\n" +
                    "n\n" +
                    "0\n" +
                    "n\n" +
                    "FMA\n" +
                    "2\n" +
                    "n\n" +
                    num2 + "\n" +
                    "y\n";
    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in1 = new ByteArrayInputStream(expected1.getBytes());
    ByteArrayInputStream in2 = new ByteArrayInputStream(expected2.getBytes());

    /* helping objects */

    Department obj = new Department("Bigu");

    static Department Lambda1 = new Department("Lambda Lab");
    static Department Lambda2 = new Department("Lambda Lab");
    static Group gTest3 = new Group("TH-91", 4);

    @BeforeAll
    static void before() {
        Group gTest1 = new Group("TH-81", 3);
        Group gTest2 = new Group("TH-82", 3);

        gTest1.addStudent("Talking Head");
        gTest1.addStudent("Oingo Boingo");

        gTest2.addStudent("Death Grip");

        gTest3.addStudent("Limp Bizkit");
        gTest3.addStudent("Scary Monster");
        gTest3.addStudent("Super Creep");
        gTest3.addStudent("Queen Bee");

        Lambda1.addGroup(gTest1); // 2
        Lambda1.addGroup(gTest2); // 1
        Lambda1.addGroup(new Group("TH-83", 3));

        Lambda1.addGroup(gTest3); // 4
        Lambda1.addGroup(new Group("TH-92", 4));
        Lambda1.addGroup(new Group("TH-93", 4));
        Lambda1.addGroup(new Group("TH-94", 4));

        Lambda1.addTeacher(new Teacher("Pilot Red Sun", AcademicPosition.ASPIRANT)); // 4
        Lambda1.addTeacher(new Teacher("Men At Work", AcademicPosition.ASPIRANT));
        Lambda1.addTeacher(new Teacher("Haircuts For Men", AcademicPosition.ASPIRANT));
        Lambda1.addTeacher(new Teacher("Black Sabbath", AcademicPosition.ASPIRANT));

        Lambda1.addTeacher(new Teacher("Gaelic Storm", AcademicPosition.DOCTORAL_STUDENT)); // 3
        Lambda1.addTeacher(new Teacher("Tears For Fears", AcademicPosition.DOCTORAL_STUDENT));
        Lambda1.addTeacher(new Teacher("Slipknot", AcademicPosition.DOCTORAL_STUDENT));

        Lambda1.addTeacher(new Teacher("City Blues", AcademicPosition.PROFESSOR)); // 2
        Lambda1.addTeacher(new Teacher("Slick Rick", AcademicPosition.PROFESSOR));
    }

    @Test
    void addGroup_AddAGroup_True() throws IOException {
        System.setIn(in1);

        assertTrue(obj.addGroup());

        System.setIn(sysInBackup);
    }

    @Test
    void addGroup_AddTwoEqualGroups_False() throws IOException {
        System.setIn(in1);

        obj.addGroup();
        assertFalse(obj.addGroup());

        System.setIn(sysInBackup);
    }

    @Test
    void getGroup_EmptyList_Null() {
        assertNull(obj.getGroup(0));
    }

    @Test
    void getGroup_WrongNumber_Null() throws IOException {
        System.setIn(in1);

        obj.addGroup();

        System.setIn(sysInBackup);

        assertNull(obj.getGroup(4));
    }

    @Test
    void getGroup_GetTeacherFromList_NotNull() throws IOException {
        System.setIn(in1);

        obj.addGroup();

        System.setIn(sysInBackup);

        assertNotNull(obj.getGroup(0));
    }

    @Test
    void addTeacher_AddATeacher_True() throws IOException {
        System.setIn(in2);

        assertTrue(obj.addTeacher());

        System.setIn(sysInBackup);
    }

    @Test
    void addTeacher_AddTwoEqualTeachers_False() throws IOException {
        System.setIn(in2);

        obj.addTeacher();
        assertFalse(obj.addTeacher());

        System.setIn(sysInBackup);
    }

    @Test
    void getTeacher_EmptyList_Null(){
        assertNull(obj.getTeacher(0));
    }

    @Test
    void getTeacher_WrongNumber_Null() throws IOException {
        System.setIn(in2);

        obj.addTeacher();

        System.setIn(sysInBackup);

        assertNull(obj.getTeacher(4));
    }

    @Test
    void getTeacher_GetTeacherFromList_NotNull() throws IOException {
        System.setIn(in2);

        obj.addTeacher();

        System.setIn(sysInBackup);

        assertNotNull(obj.getTeacher(0));
    }

    @Test
    void getGroupsList_GetEmptyList_False() {
        assertFalse(obj.getGroupsList());
    }

    @Test
    void getGroupsList_GetNotEmptyList_True() throws IOException {
        System.setIn(in1);

        obj.addGroup();

        System.setIn(sysInBackup);

        assertTrue(obj.getGroupsList());
    }

    @Test
    void getTeachersList_GetEmptyList_False() {
        assertFalse(obj.getTeachersList());
    }

    @Test
    void getTeachersList_GetNotEmptyList_True() throws IOException {
        System.setIn(in1);

        obj.addTeacher();

        System.setIn(sysInBackup);

        assertTrue(obj.getTeachersList());
    }

    /* lambdas */

    /*findGroupsByYear*/
    @Test
    void findGroupsByYear_FindByTwoDifferentYears_Equals() {
        assertEquals(4, Lambda1.findGroupsByYear(4).size());
        assertEquals(3, Lambda1.findGroupsByYear(3).size());
    }

    @Test
    void findGroupsByYear_FindNonExistingGroups_Equals() {
        assertEquals(0, Lambda1.findGroupsByYear(1).size());
    }

    @Test
    void findGroupsByYear_SearchesInTheEmptyList_Equals() {
        assertEquals(0, Lambda2.findGroupsByYear(4).size());
    }

    /*countStudentsByYear*/

    @Test
    void countStudentsByYear_CountByTwoDifferentYears_Equals() {
        assertEquals(4, Lambda1.countStudentsByYear(4));
        assertEquals(3, Lambda1.countStudentsByYear(3));
    }

    @Test
    void countStudentsByYear_CountByNonExistingGroups_Equals() {
        assertEquals(0, Lambda1.countStudentsByYear(1));
    }

    @Test
    void countStudentsByYear_CountInAnEmptyList_Equals(){
        assertEquals(0, Lambda2.countStudentsByYear(4));
    }

    /*maxStudentsInGroup*/

    @Test
    void maxStudentsInGroup_FindMaxInAListWithGroups_Equals() throws Department.EmptyListException {
        assertEquals(gTest3, Lambda1.maxStudentsInGroup());
    }

    @Test
    void maxStudentsInGroup_FindMaxInAnEmptyList_Equals() {
        assertThrows(Department.EmptyListException.class, Lambda2::maxStudentsInGroup);
    }

    /*avgNumberOfStudents*/

    @Test
    void avgNumberOfStudents_FindAvgInAListWithGroups_Equals() throws Department.EmptyListException {
        assertEquals(1.0, Lambda1.avgNumberOfStudents());
    }

    @Test
    void avgNumberOfStudents_FindAvgInAnEmptyList_Equals() {
        assertThrows(Department.EmptyListException.class, Lambda2::avgNumberOfStudents);
    }

    /*splitGroupsByYear*/

    @Test
    void splitGroupsByYear_SplitByTwoExistingYears_Equals() {
        assertEquals(4, Lambda1.splitGroupsByYear(4).get(true).size());
        assertEquals(3, Lambda1.splitGroupsByYear(4).get(false).size());
    }

    @Test
    void splitGroupsByYear_SplitByNonExistingYear_Equals() {
        assertEquals(0, Lambda1.splitGroupsByYear(1).get(true).size());
    }

    @Test
    void splitGroupsByYear_SplitAnEmptyList_Equals() {
        assertEquals(0, Lambda2.splitGroupsByYear(4).get(true).size());
        assertEquals(0, Lambda2.splitGroupsByYear(4).get(false).size());
    }

    /*findTeachersByPosition*/

    @Test
    void findTeachersByPosition_FindByTwoDifferentPositions_Equals() {
        assertEquals(4, Lambda1.findTeachersByPosition(AcademicPosition.ASPIRANT).size());
        assertEquals(3, Lambda1.findTeachersByPosition(AcademicPosition.DOCTORAL_STUDENT).size());
    }

    @Test
    void findTeachersByPosition_FindNonExistingGroups_Equals() {
        assertEquals(0, Lambda1.findTeachersByPosition(AcademicPosition.LECTURER).size());
    }

    @Test
    void findTeachersByPosition_SearchesInTheEmptyList_Equals() {
        assertEquals(0, Lambda2.findTeachersByPosition(AcademicPosition.ASPIRANT).size());
    }

    /*splitTeachersByPosition*/

    @Test
    void splitTeachersByPosition_SplitByTwoExistingPositions_Equals() {
        assertEquals(4, Lambda1.splitTeachersByPosition(AcademicPosition.ASPIRANT).get(true).size());
        assertEquals(5, Lambda1.splitTeachersByPosition(AcademicPosition.ASPIRANT).get(false).size());
    }

    @Test
    void splitTeachersByPosition_SplitByNonExistingPosition_Equals() {
        assertEquals(0, Lambda1.splitTeachersByPosition(AcademicPosition.LECTURER).get(true).size());
    }

    @Test
    void splitTeachersByPosition_SplitAnEmptyList_Equals() {
        assertEquals(0, Lambda2.splitTeachersByPosition(AcademicPosition.ASPIRANT).get(true).size());
        assertEquals(0, Lambda2.splitTeachersByPosition(AcademicPosition.ASPIRANT).get(false).size());
    }


//    @Test
//    void hashCode_CompareEqualDepartmentHashCodes_Equals() {
//        assertEquals(s1.hashCode(), s2.hashCode());
//        assertEquals(s1.hashCode(), s1.hashCode());
//    }
//
//    @Test
//    void hashCode_CompareNotEqualDepartmentHashCodes_NotEquals() {
//        assertNotEquals(obj.hashCode(), s1.hashCode());
//    }
//
//    @Test
//    void equals_CompareNotEqualDepartments_NotEquals() {
//        HashCodeTestClass O = new HashCodeTestClass();
//        O.hashcode = s2.hashCode();
//        assertFalse(s2.equals(O));
//        assertNotEquals(obj, s1);
//    }
//
//    @Test
//    void equals_CompareEqualDepartments_Equals() {
//        assertEquals(s1, s2);
//    }
}