package com.company.services.hei;

import com.company.domain.hei.Department;
import com.company.domain.people.Student;
import com.company.repository.dao.hei.DepartmentRepository;
import com.company.repository.interfaces.RepositoryInt;
import com.company.services.interfaces.hei.DepartmentService;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<Student> getStudentsFromGroup(long groupId) {
        throw new NotImplementedException("");
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
