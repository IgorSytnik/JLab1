package com.company.services.inanimate.subject;

import com.company.domain.inanimate.subject.Grade;
import com.company.exceptoins.GradeException;
import com.company.repository.dao.inanimate.GroupRepository;
import com.company.repository.dao.inanimate.subject.GradeDateRepository;
import com.company.repository.dao.inanimate.subject.GradeRepository;
import com.company.services.interfaces.inanimate.subject.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private GradeRepository repository;

    @Override
    public Grade make(Grade ob) {
        return repository.saveAndFlush(ob);
    }

    @Override
    public List<Grade> getAll() {
        return repository.findAll();
    }

    @Override
    public Grade findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find grade with id " + id));
    }

    @Override
    public List<Grade> makeMany(Collection<Grade> grades) {
        return repository.saveAll(grades);
    }
}
