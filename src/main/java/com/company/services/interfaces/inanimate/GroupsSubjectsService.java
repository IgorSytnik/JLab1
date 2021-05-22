package com.company.services.interfaces.inanimate;

import com.company.domain.inanimate.Group;
import com.company.domain.inanimate.GroupsSubjects;
import com.company.domain.inanimate.subject.Work;
import com.company.services.interfaces.Common;

import java.util.Collection;

public interface GroupsSubjectsService extends Common<GroupsSubjects> {
    Collection<Work> getWorks(long id);
}
