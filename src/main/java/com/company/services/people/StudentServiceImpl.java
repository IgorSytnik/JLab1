package com.company.services.people;

import com.company.domain.inanimate.subject.Grade;
import com.company.domain.inanimate.subject.ListHasStudents;
import com.company.domain.inanimate.subject.Subject;
import com.company.domain.people.Student;
import com.company.domain.inanimate.subject.Work;
import com.company.repository.dao.people.StudentRepository;
import com.company.services.interfaces.people.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    public void addGrades(Map<Student, List<Grade>> mapGrades, Subject subject) {
        mapGrades.forEach((k, v) -> {
            k.getListHasStudentsList().stream()
                    .filter(ob -> ob.getGroupsSubjects().
                            getSubject().
                            equals(subject))
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("Student " + k + " doesn't have subject " +
                            subject))
                    .getGrades()
                    .addAll(v);
        });
    }

    public void addAttestations(Map<Student, Boolean> mapAttest, Subject subject) {
        mapAttest.forEach((k, v) -> {
            k.getListHasStudentsList().stream()
                    .filter(ob -> ob.getGroupsSubjects().
                            getSubject().
                            equals(subject))
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("Student " + k + " doesn't have subject " +
                            subject))
                    .addAttest(v);
        });
    }

    public List<Grade> getGrades(Student student, Subject subject) {
        return student.getListHasStudentsList().stream()
                .filter(ob -> ob.getGroupsSubjects().
                        getSubject().
                        equals(subject))
                .flatMap(ob -> ob.getGrades().stream())
                .collect(Collectors.toList());
    }

    public List<ListHasStudents> getAttestations(Student student, Subject subject) {
        return student.getListHasStudentsList().stream()
                .filter(ob -> ob.getGroupsSubjects()
                        .getSubject()
                        .equals(subject))
                .collect(Collectors.toList());
    }

    public Student getStudentById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find student with id " + id));
    }

    public boolean handOverWork(Work work, String file, Student student) {
        return student.handOverWork(work, file);
    }

}
