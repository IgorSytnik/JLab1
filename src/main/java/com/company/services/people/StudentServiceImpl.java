package com.company.services.people;

import com.company.domain.people.Student;
import com.company.domain.people.Subject;
import com.company.domain.people.Work;
import com.company.repository.interfaces.RepositoryInt;
import com.company.services.interfaces.people.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private RepositoryInt<Student> repository;

    public void addGrades(Map<Student, Map<Date, Integer>> mapGrades, Subject subject) {
        mapGrades.forEach((k, v) -> {
            k.getSubjects()
                    .get(subject)
                    .addGradesAsMap(v);
            repository.update(k);
        });
    }

    public void addAttestations(Map<Student, Boolean> mapAttest, Subject subject) {
        mapAttest.forEach((k, v) -> {
            if ( k.getSubjects()
                    .get(subject).getAttestationCount() >= 2) return;
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

    public Student getStudentById(long id) {
        return repository.findById(id);
    }

    public String handOverWork(Work work, String file, Student student) {
        return student.handOverWork(work, file);
    }

}
