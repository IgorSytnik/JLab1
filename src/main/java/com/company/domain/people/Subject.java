package com.company.domain.people;

import com.company.domain.ClassWithName;
import com.company.exceptoins.CannotAddGradeException;

import java.util.ArrayList;
import java.util.List;

public class Subject extends ClassWithName {

    private List<Integer> grades = new ArrayList<>();
    private int gradesCapacity;

    public Subject(String name) {
        this.name = name;
    }

    public Subject(String name, int gradesCapacity) {
        this.name = name;
        grades = new ArrayList<>(gradesCapacity);
        this.gradesCapacity = gradesCapacity;
    }

    public void addGrade(int grade) {
        if (grades.size() >= gradesCapacity) throw new CannotAddGradeException(name);
        grades.add(grade);
    }
}
