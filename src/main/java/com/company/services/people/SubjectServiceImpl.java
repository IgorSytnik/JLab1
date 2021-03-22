package com.company.services.people;

import com.company.domain.people.Subject;
import com.company.repository.people.SubjectRepisitory;

public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepisitory repisitory;

    public SubjectServiceImpl(SubjectRepisitory repisitory) {
        this.repisitory = repisitory;
    }

    @Override
    public Subject getSubjectById(long subjectId) {
        return repisitory.findById(subjectId);
    }
}
