package com.company.repository.dao.people;

import com.company.domain.inanimate.subject.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {
//    @Override
//    public Work findById(long id) {
//        return null;
//    }
//
//    @Override
//    public List<Work> findAll() {
//        return null;
//    }
//
//    @Override
//    public Work save(Work subject) {
//        return null;
//    }
//
//    @Override
//    public Work update(Work subject) {
//        return null;
//    }
//
//    @Override
//    public Work delete(Work subject) {
//        return null;
//    }
}
