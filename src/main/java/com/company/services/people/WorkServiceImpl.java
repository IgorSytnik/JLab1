package com.company.services.people;

import com.company.domain.inanimate.subject.Work;
import com.company.repository.dao.people.WorkRepository;
import com.company.services.interfaces.people.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkRepository repository;

    public Work getWorkById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find work with id " + id));
    }
}
