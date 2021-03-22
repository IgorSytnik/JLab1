package com.company.services.people;

import com.company.domain.people.Group;
import com.company.domain.people.Student;
import com.company.domain.people.Subject;
import com.company.repository.people.GroupRepository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Map;

public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;

    public GroupServiceImpl(GroupRepository repository) {
        this.repository = repository;
    }

    public Group getGroupById(long groupId) {
        return repository.findById(groupId);
    }

    public List<Student> getStudentsFromGroup(long groupId) {
        return repository.findById(groupId).getStudents();
    }

}
