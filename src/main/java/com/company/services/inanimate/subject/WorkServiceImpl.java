package com.company.services.inanimate.subject;

import com.company.domain.inanimate.subject.Work;
import com.company.repository.dao.inanimate.subject.WorkRepository;
import com.company.services.interfaces.inanimate.subject.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkRepository repository;

    @Override
    public Work make(Work ob) {
        return repository.saveAndFlush(ob);
    }

    @Override
    public Collection<Work> makeMany(Collection<Work> collection) {
        return repository.saveAll(collection);
    }

    @Override
    public List<Work> getAll() {
        return repository.findAll();
    }

    @Override
    public Work findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find work with id " + id));
    }
}
