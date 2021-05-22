package com.company.services.inanimate;

import com.company.domain.inanimate.Group;
import com.company.domain.people.Student;
import com.company.domain.inanimate.subject.Work;
import com.company.repository.dao.inanimate.GroupRepository;
import com.company.services.interfaces.inanimate.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository repository;

    @Override
    public Group findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find group with id " + id));
    }

    @Override
    public Group make(Group group) {
        return repository.saveAndFlush(group);
    }

    @Override
    public Collection<Group> makeMany(Collection<Group> collection) {
        return repository.saveAll(collection);
    }

    @Override
    public List<Group> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Student> getStudentsFromGroup(long id) {
        return findById(id)
                .getStudents();
    }

}
