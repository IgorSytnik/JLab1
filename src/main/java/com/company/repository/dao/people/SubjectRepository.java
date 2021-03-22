package com.company.repository.dao.people;

import com.company.domain.people.Subject;
import com.company.repository.interfaces.RepositoryInt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectRepository implements RepositoryInt<Subject> {
    @Override
    public Subject findById(long id) {
        return null;
    }

    @Override
    public List<Subject> findAll() {
        return null;
    }

    @Override
    public Subject save(Subject subject) {
        return null;
    }

    @Override
    public Subject update(Subject subject) {
        return null;
    }

    @Override
    public Subject delete(Subject subject) {
        return null;
    }
}
