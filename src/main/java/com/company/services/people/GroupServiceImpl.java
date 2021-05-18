package com.company.services.people;

import com.company.domain.inanimate.Group;
import com.company.domain.people.Student;
import com.company.domain.inanimate.subject.Work;
import com.company.repository.dao.people.GroupRepository;
import com.company.services.interfaces.people.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository repository;

    public Group getGroupById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find group with id " + id));
    }

    public List<Student> getStudentsFromGroup(long id) {
        return getGroupById(id)
                .getStudents();
    }

    public List<Work> getWorks(Group group) {
        return group.getWorks();
    }

}
