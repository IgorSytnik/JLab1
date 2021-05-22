package com.company.services.interfaces.inanimate;

import com.company.domain.inanimate.Group;
import com.company.domain.people.Student;
import com.company.domain.inanimate.subject.Work;
import com.company.services.interfaces.Common;

import java.util.List;

public interface GroupService extends Common<Group> {
    List<Student> getStudentsFromGroup(long groupId);
}
