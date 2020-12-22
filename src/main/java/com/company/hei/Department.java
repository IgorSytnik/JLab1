package com.company.hei;

import com.company.people.AcademicPosition;
import com.company.people.Group;
import com.company.people.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Department extends Institution {
    private List<Group> groups = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public Department() throws IOException {
        this.name = this.enterName();
    }
    public Department(String n) {
        this.name = n;
    }

    private boolean lookUp(final String obName) {
        return groups.stream().anyMatch(o -> o.getName().equals(obName));
    }

    public boolean addGroup(Group g) {
        if(lookUp(g.getName())) {
            System.out.println("This department already has this group ");
            return false;
        } else {
            groups.add(g);
            return true;
        }
    }

    public boolean addGroup() throws IOException {
        return addGroup(new Group());
    }

    public boolean addTeacher(Teacher t) {
        if(teachers.contains(t)) {
            System.out.println("This department already has this Teacher ");
            return false;
        } else {
            teachers.add(t);
            return true;
        }
    }

    public boolean addTeacher() throws IOException {
        return addTeacher(new Teacher());
    }

    public boolean getGroupsList() {
        return getList(groups, "groups");
    }

    public boolean getTeachersList() {
        return getList(teachers, "teachers");
    }

    public Group getGroup(int i) {
        return (Group) getOne(groups, "groups", i);
    }

    public Teacher getTeacher(int i) {
        return (Teacher) getOne(teachers, "teachers", i);
    }

    /*group list lambdas*/
    public List<Group> findGroupsByYear(int year) {
        return groups.stream()
                .filter(g -> g.getYear() == year)
                .collect(Collectors.toList());
    }

    public int countStudentsByYear(int year) {
        return groups.stream()
                .filter(g -> g.getYear() == year)
                .mapToInt(g -> g.getStudentsList().size())
                .sum();
    }

    public static class EmptyListException
            extends Exception {
        public EmptyListException(String errorMessage) {
            super(errorMessage);
        }
    }

    public Group maxStudentsInGroup() throws EmptyListException {
        return groups.stream()
                .max(Comparator.comparing(g -> g.getStudentsList().size()))
                .orElseThrow(() ->
                        new EmptyListException("The List of groups is empty"));
    }

    public double avgNumberOfStudents() throws EmptyListException {
        return groups.stream()
                .mapToInt(g -> g.getStudentsList().size())
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

