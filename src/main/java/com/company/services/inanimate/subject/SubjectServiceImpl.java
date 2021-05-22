package com.company.services.inanimate.subject;

import com.company.domain.hei.Department;
import com.company.domain.inanimate.subject.Subject;
import com.company.repository.dao.inanimate.subject.SubjectRepository;
import com.company.services.interfaces.inanimate.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repository;

    @Override
    public Subject findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find subject with id " + id));
    }

    @Override
    public Subject make(Subject ob) {
        return repository.saveAndFlush(ob);
    }

    @Override
    public Collection<Subject> makeMany(Collection<Subject> collection) {
        return repository.saveAll(collection);
    }

    @Override
    public List<Subject> getAll() {
        return repository.findAll();
    }
}
