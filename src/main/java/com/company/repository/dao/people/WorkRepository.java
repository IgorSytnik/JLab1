package com.company.repository.dao.people;

import com.company.domain.people.Subject;
import com.company.domain.people.Work;
import com.company.repository.interfaces.RepositoryInt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkRepository implements RepositoryInt<Work> {
    @Override
    public Work findById(long id) {
        return null;
    }

    @Override
    public List<Work> findAll() {
        return null;
    }

    @Override
    public Work save(Work subject) {
        return null;
    }

    @Override
    public Work update(Work subject) {
        return null;
    }

    @Override
    public Work delete(Work subject) {
        return null;
    }
}
