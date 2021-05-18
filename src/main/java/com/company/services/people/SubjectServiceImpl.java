package com.company.services.people;

import com.company.domain.inanimate.subject.Subject;
import com.company.repository.dao.people.SubjectRepository;
import com.company.services.interfaces.people.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repository;

    public Subject getSubjectById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find subject with id " + id));
    }
}
