package com.company.repository.hei;

import com.company.domain.hei.Department;

import java.util.List;

public interface DepartmentRepository
//        extends CrudRepository<Department, Long>
{
    Department findById(long id);
    List<Department> findAll();
    Department save(Department department);
    Department update(Department department);
    Department delete(Department department);
}
