package com.company.services.inanimate;

import com.company.domain.inanimate.StudentsHasWorks;
import com.company.repository.dao.inanimate.StudentsHasWorksRepository;
import com.company.services.interfaces.inanimate.StudentsHasWorksService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentsHasWorksServiceImpl implements StudentsHasWorksService {

    StudentsHasWorksRepository repository;

    @Override
    public StudentsHasWorks make(StudentsHasWorks ob) {
        return repository.saveAndFlush(ob);
    }

    @Override
    public Collection<StudentsHasWorks> makeMany(Collection<StudentsHasWorks> collection) {
        return repository.saveAll(collection);
    }

    @Override
    public Collection<StudentsHasWorks> getAll() {
        return repository.findAll();
    }

    @Override
    public StudentsHasWorks findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find student's work with id " + id));
    }
}
