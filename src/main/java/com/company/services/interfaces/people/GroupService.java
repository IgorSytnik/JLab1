package com.company.services.interfaces.people;

import com.company.domain.inanimate.Group;
import com.company.domain.people.Student;
import com.company.domain.inanimate.subject.Work;

import java.util.List;

public interface GroupService {
    Group getGroupById(long GroupId);
    List<Student> getStudentsFromGroup(long groupId);
    List<Work> getWorks(Group group);
    void makeGroup(Group group);
    List<Group> getGroups();

}
