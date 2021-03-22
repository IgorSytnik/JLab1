package com.company.services.people;

import com.company.domain.people.Group;
import com.company.domain.people.Student;
import com.company.domain.people.Work;
import com.company.repository.interfaces.RepositoryInt;
import com.company.services.interfaces.people.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private RepositoryInt<Group> repository;

    public Group getGroupById(long groupId) {
        return repository.findById(groupId);
    }

    public List<Student> getStudentsFromGroup(long groupId) {
        return repository.findById(groupId).getStudents();
    }

    public List<Work> getWorks(Group group) {
        return group.getSubjects()
                .stream()
                .flatMap(e -> e.getWorks().stream())
                .collect(Collectors.toList());
    }

}
