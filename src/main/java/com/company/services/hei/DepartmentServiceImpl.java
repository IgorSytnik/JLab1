package com.company.services.hei;

import com.company.domain.hei.Department;
import com.company.repository.dao.hei.DepartmentRepository;
import com.company.services.interfaces.hei.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department make(Department ob) {
        return repository.saveAndFlush(ob);
    }

    @Override
    public Collection<Department> makeMany(Collection<Department> collection) {
        return repository.saveAll(collection);
    }

    @Override
    public List<Department> getAll() {
        return repository.findAll();
    }

    @Override
    public Department findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find department with id " + id));
    }

    /*public List<Group> findGroupsByYear(int year) {
        throw new NotImplementedException("");
    }
    public int countStudentsByYear(int year) {
        throw new NotImplementedException("");
    }
    public Group maxStudentsInGroup() {
        throw new NotImplementedException("");
    }
    public double avgNumberOfStudents() {
        throw new NotImplementedException("");
    }
    public Map<Boolean, List<Group>> splitGroupsByYear(int year) {
        throw new NotImplementedException("");
    }
    public List<Teacher> findTeachersByPosition(AcademicPosition position) {
        throw new NotImplementedException("");
    }
    public Map<Boolean, List<Teacher>> splitTeachersByPosition(AcademicPosition position) {
        throw new NotImplementedException("");
    }*/
}
