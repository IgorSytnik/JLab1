package com.company.services.people;

import com.company.domain.people.Subject;
import com.company.repository.interfaces.RepositoryInt;
import com.company.services.interfaces.people.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private RepositoryInt<Subject> repository;

    public Subject getSubjectById(long subjectId) {
        return repository.findById(subjectId);
    }
}
