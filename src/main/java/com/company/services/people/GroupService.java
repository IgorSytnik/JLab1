package com.company.services.people;

import com.company.domain.people.Group;
import com.company.domain.people.Student;

import java.util.List;

public interface GroupService {
    Group getGroupById(long GroupId);
    List<Student> getStudentsFromGroup(long groupId);
}
