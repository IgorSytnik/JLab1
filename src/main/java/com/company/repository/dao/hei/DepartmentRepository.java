package com.company.repository.dao.hei;

import com.company.domain.hei.Department;
import com.company.repository.interfaces.RepositoryInt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository implements RepositoryInt<Department> {
    @Override
    public Department findById(long id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public Department save(Department department) {
        return null;
    }

    @Override
    public Department update(Department department) {
        return null;
    }

    @Override
    public Department delete(Department department) {
        return null;
    }
}
