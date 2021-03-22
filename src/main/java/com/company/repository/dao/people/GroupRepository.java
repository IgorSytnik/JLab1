package com.company.repository.dao.people;

import com.company.domain.people.Group;
import com.company.repository.interfaces.RepositoryInt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupRepository implements RepositoryInt<Group> {
    @Override
    public Group findById(long id) {
        return null;
    }

    @Override
    public List<Group> findAll() {
        return null;
    }

    @Override
    public Group save(Group group) {
        return null;
    }

    @Override
    public Group update(Group group) {
        return null;
    }

    @Override
    public Group delete(Group group) {
        return null;
    }
}
