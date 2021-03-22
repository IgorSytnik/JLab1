package com.company.repository.people;

import com.company.domain.people.Teacher;

import java.util.List;

public interface TeacherRepository
//        extends CrudRepository<Teacher, Long>
{
    Teacher findById(long id);
    List<Teacher> findAll();
    Teacher save(Teacher teacher);
    Teacher update(Teacher teacher);
    Teacher delete(Teacher teacher);
}
