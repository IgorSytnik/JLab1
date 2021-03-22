package com.company.repository.people;

import com.company.domain.people.Group;

import java.util.List;

public interface GroupRepository
//        extends CrudRepository<Group, Long>
{
    Group findById(long id);
    List<Group> findAll();
    Group save(Group group);
    Group update(Group group);
    Group delete(Group group);
}
