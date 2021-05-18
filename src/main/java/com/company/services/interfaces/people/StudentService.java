package com.company.services.interfaces.people;

import com.company.domain.inanimate.Group;
import com.company.domain.inanimate.subject.Grade;
import com.company.domain.inanimate.subject.ListHasStudents;
import com.company.domain.people.Student;
import com.company.domain.inanimate.subject.Subject;
import com.company.domain.inanimate.subject.Work;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentService {
    void addGrades(Map<Student, List<Grade>> mapGrades, Subject subject);
    void addAttestations(Map<Student, Boolean> mapAttest, Subject subject);
    List<Grade> getGrades(Student student, Subject subject);
    List<ListHasStudents> getAttestations(Student student, Subject subject);
    Student getStudentById (long id);
    boolean handOverWork (Work work, String file, Student student);
    void makeStudent(Student student);
    List<Student> getStudents();
}
