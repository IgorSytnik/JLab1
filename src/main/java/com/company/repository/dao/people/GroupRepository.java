package com.company.repository.dao.people;

import com.company.domain.inanimate.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
//    @Override
//    public Group findById(long id) {
//        return null;
//    }
//
//    @Override
//    public List<Group> findAll() {
//        return null;
//    }
//
//    @Override
//    public Group save(Group group) {
//        return null;
//    }
//
//    @Override
//    public Group update(Group group) {
//        return null;
//    }
//
//    @Override
//    public Group delete(Group group) {
//        return null;
//    }
}
