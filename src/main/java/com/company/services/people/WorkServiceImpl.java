package com.company.services.people;

import com.company.domain.people.Work;
import com.company.repository.interfaces.RepositoryInt;
import com.company.services.interfaces.people.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private RepositoryInt<Work> repository;

    public Work getWorkById(long workId) {
        return repository.findById(workId);
    }
}
