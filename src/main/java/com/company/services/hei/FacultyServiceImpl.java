package com.company.services.hei;

import com.company.domain.hei.Faculty;
import com.company.domain.inanimate.Group;
import com.company.repository.dao.hei.FacultyRepository;
import com.company.services.interfaces.hei.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository repository;

    @Override
    public Faculty getFacultyById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find faculty with id " + id));
    }

    @Override
    public void makeFaculty(Faculty faculty) {
        repository.save(faculty);
    }

    @Override
    public List<Faculty> getFaculties() {
        return repository.findAll();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
