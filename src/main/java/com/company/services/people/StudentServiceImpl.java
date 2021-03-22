package com.company.services.people;

import com.company.domain.people.Student;
import com.company.domain.people.Subject;
import com.company.repository.people.StudentRepository;

import java.util.Date;
import java.util.Map;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    public void addGrades(Map<Student, Map<Date, Integer>> mapGrades, Subject subject) {
        mapGrades.forEach((k, v) -> {
            k.getSubjects()
                    .get(subject)
                    .addGradesAsMap(v);
            repository.save(k);
        });
    }

    public void addAttestations(Map<Student, Boolean> mapAttest, Subject subject) {
        mapAttest.forEach((k, v) -> {
            k.getSubjects()
                    .get(subject)
                    .addAttestation(v);
            repository.update(k);
        });
    }

    public Map<Date, Integer> getGrades(Student student, Subject subject) {
        return student.getSubjects().get(subject).getGrades();
    }

    public boolean[] getAttestations(Student student, Subject subject) {
        return student.getSubjects().get(subject).getAttestations();
    }

}
