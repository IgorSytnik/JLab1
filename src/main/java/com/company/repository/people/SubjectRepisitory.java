package com.company.repository.people;

import com.company.domain.people.Subject;

import java.util.List;

public interface SubjectRepisitory {
    Subject findById(long id);
    List<Subject> findAll();
    Subject save(Subject subject);
    Subject update(Subject subject);
    Subject delete(Subject subject);
}
