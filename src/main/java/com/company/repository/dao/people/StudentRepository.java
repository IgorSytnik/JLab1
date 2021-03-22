package com.company.repository.dao.people;

import com.company.domain.people.Student;
import com.company.repository.interfaces.RepositoryInt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository implements RepositoryInt<Student> {
    @Override
    public Student findById(long id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public Student delete(Student student) {
        return null;
    }
}
