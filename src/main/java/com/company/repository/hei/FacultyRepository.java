package com.company.repository.hei;

import com.company.domain.hei.Faculty;

import java.util.List;

public interface FacultyRepository
//        extends CrudRepository<Faculty, Long>
{
    Faculty findById(long id);
    List<Faculty> findAll();
    Faculty save(Faculty faculty);
    Faculty update(Faculty faculty);
    Faculty delete(Faculty faculty);
}
