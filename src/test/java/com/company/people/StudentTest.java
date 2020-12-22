package com.company.people;

class StudentTest {
    String name = "Tim Shaq";
    String group = "XX-00";
    int year = 3;
    Student s1 = new Student(name, group, year);
    Student s2 = new Student(name, group, year);
    Student obj = new Student("Bigu", group, year);

//    @Test
//    void toString_CompareEqualNames_Equals() {
//        assertEquals(name + ", group: " + group + ", year: " + year, s1.toString());
//        assertEquals(s2.toString(), s1.toString());
//        assertEquals(s1.toString(), s1.toString());
//    }
//
//    @Test
//    void toString_CompareNonEqualNames_NotEquals() {
//        assertNotEquals(obj.toString(), s1.toString());
//    }
//
//    @Test
//    void hashCode_CompareEqualStudentHashCodes_Equals() {
//        assertEquals(s1.hashCode(), s2.hashCode());
//        assertEquals(s1.hashCode(), s1.hashCode());
//    }
//
//    @Test
//    void hashCode_CompareNotEqualStudentHashCodes_NotEquals() {
//        assertNotEquals(obj.hashCode(), s1.hashCode());
//    }
//
//    @Test
//    void equals_CompareNotEqualStudents_NotEquals() {
//        HashCodeTestClass O = new HashCodeTestClass();
//        O.hashcode = s2.hashCode();
//        assertFalse(s2.equals(O));
//        assertNotEquals(obj, s1);
//    }
//
//    @Test
//    void equals_CompareEqualStudents_Equals() {
//        assertEquals(s1, s2);
//    }
}