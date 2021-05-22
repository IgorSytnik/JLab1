package com.company.controllers;

import com.company.domain.hei.Department;
import com.company.domain.hei.Faculty;
import com.company.domain.inanimate.Group;
import com.company.domain.inanimate.GroupsSubjects;
import com.company.domain.inanimate.Specialty;
import com.company.domain.inanimate.subject.Grade;
import com.company.domain.inanimate.subject.ListHasStudents;
import com.company.domain.inanimate.subject.Subject;
import com.company.domain.people.AcademicPosition;
import com.company.domain.people.Student;
import com.company.domain.people.Teacher;
import com.company.repository.dao.inanimate.GroupsSubjectsRepository;
import com.company.services.interfaces.hei.DepartmentService;
import com.company.services.interfaces.hei.FacultyService;
import com.company.services.interfaces.inanimate.GroupService;
import com.company.services.interfaces.inanimate.GroupsSubjectsService;
import com.company.services.interfaces.inanimate.SpecialtyService;
import com.company.services.interfaces.inanimate.subject.ListHasStudentsService;
import com.company.services.interfaces.inanimate.subject.SubjectService;
import com.company.services.interfaces.people.StudentService;
import com.company.services.interfaces.people.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class ModeratorController {

    private final GroupService groupService;
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final FacultyService facultyService;
    private final DepartmentService departmentService;
    private final TeacherService teacherService;
    private final SpecialtyService specialtyService;
    private final GroupsSubjectsService groupsSubjectsService;
    private final ListHasStudentsService listHasStudentsService;

    public Faculty makeFaculty(String name) {
        return facultyService.make(new Faculty(name));
    }

    public List<Faculty> getAllFaculties() {
        return (List<Faculty>) facultyService.getAll();
    }

    public void deleteAllFaculties() {
        facultyService.deleteAll();
    }

    public Specialty makeSpecialty(String name) {
        return specialtyService.make(new Specialty(name));
    }

    public Subject makeSubject(String name) {
        return subjectService.make(new Subject(name));
    }

    public Department makeDepartment(String name, long facultyId) {
        return departmentService.make(new Department(name, facultyService.findById(facultyId)));
    }

    public Teacher makeTeacher(String name, AcademicPosition position, long departmentId) {
        return teacherService.make(new Teacher(name, position, departmentService.findById(departmentId)));
    }

    public Group makeGroup(String name, int year, long departmentId, long specialtyId) {
        return groupService.make(new Group(name, year,
                departmentService.findById(departmentId),
                specialtyService.findById(specialtyId)));
    }

    public GroupsSubjects makeGroupSubject(long groupId, long subjectId, long teacherId) {
        return groupsSubjectsService.make(new GroupsSubjects(
                groupService.findById(groupId),
                subjectService.findById(subjectId),
                teacherService.findById(teacherId)
        ));
    }

    public Student makeStudent(String name, long groupId) {
        return studentService.make(new Student( name,
                groupService.findById(groupId)
        ));
    }

    public ListHasStudents makeListHasStudents(long groupSubjId, long studentId) {
        return listHasStudentsService.make(new ListHasStudents(
                groupsSubjectsService.findById(groupSubjId),
                studentService.findById(studentId)
        ));
    }
}
