package com.company.services.inanimate;

import com.company.domain.inanimate.Specialty;
import com.company.repository.dao.inanimate.SpecialtyRepository;
import com.company.services.interfaces.inanimate.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    SpecialtyRepository repository;

    @Override
    public Specialty make(Specialty ob) {
        return repository.saveAndFlush(ob);
    }

    @Override
    public Collection<Specialty> makeMany(Collection<Specialty> collection) {
        return repository.saveAll(collection);
    }

    @Override
    public List<Specialty> getAll() {
        return repository.findAll();
    }

    @Override
    public Specialty findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find specialty with id " + id));
    }
}
