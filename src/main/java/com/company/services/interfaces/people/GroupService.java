package com.company.services.interfaces.people;

import com.company.domain.people.Group;
import com.company.domain.people.Student;
import com.company.domain.people.Work;

import java.util.List;

public interface GroupService {
    Group getGroupById(long GroupId);
    List<Student> getStudentsFromGroup(long groupId);
    List<Work> getWorks(Group group);

}
