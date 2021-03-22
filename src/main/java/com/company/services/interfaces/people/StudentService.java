package com.company.services.interfaces.people;

import com.company.domain.people.Group;
import com.company.domain.people.Student;
import com.company.domain.people.Subject;
import com.company.domain.people.Work;

import java.util.Date;
import java.util.Map;

public interface StudentService {
    void addGrades(Map<Student, Map<Date, Integer>> mapGrades, Subject subject);
    void addAttestations(Map<Student, Boolean> mapAttest, Subject subject);
    Map<Date,Integer> getGrades(Student student, Subject subject);
    boolean[] getAttestations(Student student, Subject subject);
    Student getStudentById (long id);
    String handOverWork (Work work, String file, Student student);
}
