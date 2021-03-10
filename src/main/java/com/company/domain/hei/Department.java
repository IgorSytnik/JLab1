package com.company.domain.hei;

import com.company.exceptoins.EmptyListException;
import com.company.domain.people.AcademicPosition;
import com.company.domain.people.Group;
import com.company.domain.people.Teacher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Department extends Institution {
    private final List<Group> groups = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();

    public Department(String n) {
        this.name = n;
    }

    private boolean lookUp(final String obName) {
        return groups.stream().anyMatch(o -> o.getName().equals(obName));
    }

    public boolean addGroup(Group g) {
        if(lookUp(g.getName())) {
            return false;
        } else {
            groups.add(g);
            return true;
        }
    }

    public boolean addTeacher(Teacher t) {
        if(teachers.contains(t)) {
            return false;
        } else {
            teachers.add(t);
            return true;
        }
    }

    public boolean showGroupsList() {
        return showList(groups, "groups");
    }

    public boolean showTeachersList() {
        return showList(teachers, "teachers");
    }

    public Group getGroup(int i) throws EmptyListException {
        return (Group) getOne(groups, "groups", i);
    }

    public Teacher getTeacher(int i) throws EmptyListException {
        return (Teacher) getOne(teachers, "teachers", i);
    }

    /** group list lambdas */
    public List<Group> findGroupsByYear(int year) {
        return groups.stream()
                .filter(g -> g.getYear() == year)
                .collect(Collectors.toList());
    }

    public int countStudentsByYear(int year) {
        return groups.stream()
                .filter(g -> g.getYear() == year)
                .mapToInt(g -> g.getStudents().size())
                .sum();
    }

    public Group maxStudentsInGroup() throws EmptyListException {
        return groups.stream()
                .max(Comparator.comparing(g -> g.getStudents().size()))
                .orElseThrow(() ->
                        new EmptyListException("The List of groups is empty"));
    }

    public double avgNumberOfStudents() throws EmptyListException {
        return groups.stream()
                .mapToInt(g -> g.getStudents().size())
                .average()
                .orElseThrow(() ->
                        new EmptyListException("The List of groups is empty"));
    }

    public Map<Boolean, List<Group>> splitGroupsByYear(int year) {
        return groups.stream().
                collect(Collectors.partitioningBy(g -> g.getYear() == year));
    }

    /*teacher list lambdas*/
    public List<Teacher> findTeachersByPosition(AcademicPosition position) {
        return teachers.stream()
                .filter(t -> t.getPosition().equals(position))
                .collect(Collectors.toList());
    }

    public Map<Boolean, List<Teacher>> splitTeachersByPosition(AcademicPosition position) {
        return teachers.stream().
                collect(Collectors.partitioningBy(t -> t.getPosition().equals(position)));
    }

    public List<Teacher> getTeachersList() {
        return teachers;
    }

    public List<Group> getGroupsList() {
        return groups;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + groups.hashCode() + teachers.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Department) {
            Department anobj = (Department)obj;
            return this.name.equals(anobj.name)
                    & this.groups.equals(anobj.groups)
                    & this.teachers.equals(anobj.teachers);
        }
        return false;
    }
}

