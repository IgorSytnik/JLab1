package com.company.services.inanimate.subject;

import com.company.domain.inanimate.subject.ListHasStudents;
import com.company.domain.inanimate.subject.Subject;
import com.company.domain.people.Student;
import com.company.repository.dao.inanimate.GroupRepository;
import com.company.repository.dao.inanimate.subject.ListHasStudentsRepository;
import com.company.services.interfaces.inanimate.subject.ListHasStudentsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class ListHasStudentsServiceImpl implements ListHasStudentsService {

    private ListHasStudentsRepository repository;

    @Override
    public ListHasStudents make(ListHasStudents ob) {
        return repository.saveAndFlush(ob);
    }

    @Override
    public Collection<ListHasStudents> makeMany(Collection<ListHasStudents> collection) {
        return repository.saveAll(collection);
    }

    @Override
    public List<ListHasStudents> getAll() {
        return repository.findAll();
    }

    @Override
    public ListHasStudents findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find student list with id " + id));
    }

    @Override
    public void addAttestations(Map<ListHasStudents, Boolean> mapAttest) {
        mapAttest.forEach(ListHasStudents::addAttest);
    }
}
