package com.company.services.people;

import com.company.domain.people.Group;
import com.company.domain.people.Student;
import com.company.domain.people.Subject;

import java.util.Date;
import java.util.Map;

public interface StudentService {
    void addGrades(Map<Student, Map<Date, Integer>> mapGrades, Subject subject);
    void addAttestations(Map<Student, Boolean> mapAttest, Subject subject);
    Map<Date,Integer> getGrades(Student student, Subject subject);
    boolean[] getAttestations(Student student, Subject subject);
}
