package com.company.repository.dao.people;

import com.company.domain.inanimate.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
//    @Override
//    public Subject findById(long id) {
//        return null;
//    }
//
//    @Override
//    public List<Subject> findAll() {
//        return null;
//    }
//
//    @Override
//    public Subject save(Subject subject) {
//        return null;
//    }
//
//    @Override
//    public Subject update(Subject subject) {
//        return null;
//    }
//
//    @Override
//    public Subject delete(Subject subject) {
//        return null;
//    }
}
