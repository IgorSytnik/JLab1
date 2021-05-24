package com.company.services.people;

import com.company.domain.people.Student;
import com.company.domain.people.Teacher;
import com.company.repository.dao.people.TeacherRepository;
import com.company.services.interfaces.people.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository repository;

    @Override
    public Teacher make(Teacher ob) {
        return repository.saveAndFlush(ob);
    }

    @Override
    public Collection<Teacher> makeMany(Collection<Teacher> collection) {
        Collection<Teacher> collection1 = repository.saveAll(collection);
        repository.flush();
        return collection1;
    }

    @Override
    public Collection<Teacher> getAll() {
        return repository.findAll();
    }

    @Override
    public Teacher findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find teacher with id " + id));
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
