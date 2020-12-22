package com.company.people;

class TeacherTest {
    String name = "Tim Shaq";
    AcademicPosition position = AcademicPosition.ASPIRANT;
    Teacher t1 = new Teacher(name, position);
    Teacher t2 = new Teacher(name, position);
    Teacher obj = new Teacher("Bigu", AcademicPosition.DOCTORAL_STUDENT);

//    @Test
//    void toString_CompareEqualNames_Equals() {
//        assertEquals(name + ", position: " + position, t1.toString());
//        assertEquals(t2.toString(), t1.toString());
//        assertEquals(t1.toString(), t1.toString());
//    }
//
//    @Test
//    void toString_CompareNonEqualNames_NotEquals() {
//        assertNotEquals(obj.toString(), t1.toString());
//    }
//
//    @Test
//    void hashCode_CompareEqualTeacherHashCodes_Equals() {
//        assertEquals(t1.hashCode(), t2.hashCode());
//        assertEquals(t1.hashCode(), t1.hashCode());
//    }
//
//    @Test
//    void hashCode_CompareNotEqualTeacherHashCodes_NotEquals() {
//        assertNotEquals(obj.hashCode(), t1.hashCode());
//    }
//
//    @Test
//    void equals_CompareNotEqualTeachers_NotEquals() {
//        HashCodeTestClass O = new HashCodeTestClass();
//        O.hashcode = t2.hashCode();
//        assertFalse(t2.equals(O));
//        assertNotEquals(obj, t1);
//    }
//
//    @Test
//    void equals_CompareEqualTeachers_Equals() {
//        assertEquals(t1, t2);
//    }
}