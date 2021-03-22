package com.company.controllers.hei;

import com.company.domain.people.Group;
import com.company.domain.people.Student;
import com.company.domain.people.Subject;
import com.company.repository.people.StudentRepository;
import com.company.repository.people.SubjectRepisitory;
import com.company.services.people.*;
import edu.emory.mathcs.backport.java.util.Collections;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentControllerTest {

    GroupService groupService = Mockito.mock(GroupService.class);
    StudentService studentService = Mockito.mock(StudentService.class);
    SubjectService subjectService = Mockito.mock(SubjectService.class);
    Student student = Mockito.mock(Student.class);
    StudentRepository studentRepository =  Mockito.mock(StudentRepository.class);
    SubjectRepisitory subjectRepisitory =  Mockito.mock(SubjectRepisitory.class);


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void giveGrades() {
//        //GIVEN
//        Subject subject = new Subject("bruh");
//        Map minimap = Collections
//                .singletonMap("2021-03-16", 4);
//        StudentService studentService1 = new StudentServiceImpl(studentRepository);
//        SubjectService subjectService1 = new SubjectServiceImpl(subjectRepisitory);
//        Map grades = Collections
//                .singletonMap(student, minimap);
//
//        DepartmentController departmentController =
//                new DepartmentController(groupService, studentService1, subjectService1);
//
////        Mockito.when(subjectService1.getSubjectById(Mockito.any())).thenReturn(subject);
////        Mockito.doNothing().when(student.getSubjects().get(subject).addGradesAsMap(Mockito.any()));
//        Mockito.when(subjectRepisitory.findById(Mockito.any())).thenReturn(subject);
//        Mockito.doNothing().when(studentRepository.update(Mockito.any()));
//
//        //WHEN
//        departmentController.giveGrades(grades, subject.getId());
//
//        //THEN
////        assertEquals(actual, groups);
//        Mockito.verify(subjectService, Mockito.times(1))
//                .getSubjectById(Mockito.any());
//        Mockito.verify(studentRepository, Mockito.times(1))
//                .update(Mockito.any());

    }

    @Test
    void giveAttestations() {
    }

    @Test
    void getGrates() {
    }

    @Test
    void getAttestations() {
    }
}