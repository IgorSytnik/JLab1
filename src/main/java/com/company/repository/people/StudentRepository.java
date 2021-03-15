package com.company.repository.people;

import com.company.domain.people.Student;

import java.util.List;

public interface StudentRepository
//        extends CrudRepository<Student, Long>
{
    Student findById(long id);
    List<Student> findAll();
    Student save(Student student);
    Student update(Student student);
    Student delete(Student student);
}
