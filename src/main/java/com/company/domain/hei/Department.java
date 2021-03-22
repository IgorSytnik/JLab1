package com.company.domain.hei;

import com.company.exceptoins.AttestationException;
import com.company.exceptoins.EmptyListException;
import com.company.domain.people.AcademicPosition;
import com.company.domain.people.Group;
import com.company.domain.people.Teacher;

import java.util.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Department extends Institution {

    private long id;
    private final List<Group> groups = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private final Date[] attestTerms = new Date[4];
    private int attestTermCount = 0;

    public Department(String n) {
        this.name = n;
    }

    public void attestTerm(Date date1, Date date2) {
        if (attestTerms.length - 1 >= attestTermCount)
            throw new AttestationException("Can't add attestation terms");
        attestTerms[attestTermCount++] = date1;
        attestTerms[attestTermCount++] = date2;
    }

    private boolean lookUp(final String obName) {
        return groups.stream().anyMatch(o -> o.getName().equals(obName));
    }

    public boolean addGroup(Group group) {
        if (group == null) {
            throw new IllegalArgumentException("teacher must not be null");
        }
        if(lookUp(group.getName())) {
            return false;
        } else {
            groups.add(group);
            return true;
        }
    }

    public boolean addTeacher(Teacher teacher) {
        if (teacher == null) {
            throw new IllegalArgumentException("teacher must not be null");
        }
        if(teachers.contains(teacher)) {
            return false;
        } else {
            teachers.add(teacher);
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

    /**
     * @return copy of teacher list
     * */
    public List<Teacher> getTeachersList() {
        return List.copyOf(teachers);
    }

    /**
     * @return copy of group list
     * */
    public List<Group> getGroupsList() {
        return List.copyOf(groups);
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

