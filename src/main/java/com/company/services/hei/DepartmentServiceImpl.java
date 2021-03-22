package com.company.services.hei;

import com.company.domain.people.AcademicPosition;
import com.company.domain.people.Group;
import com.company.domain.people.Student;
import com.company.domain.people.Teacher;
import com.company.repository.hei.DepartmentRepository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Map;

//@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Group> findGroupsByYear(int year) {
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
    }

    public List<Student> getStudentsFromGroup(long groupId) {
        throw new NotImplementedException("");
    }
}
