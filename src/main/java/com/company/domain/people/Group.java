package com.company.domain.people;

import com.company.domain.ClassWithName;
import com.company.exceptoins.EmptyListException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group extends ClassWithName {
    private List<Student> students = new ArrayList<>();
    private int year;

    public Group(String n, int y) {
        this.name = n;
        this.year = y;
    }

    public boolean addStudent(String studentName) {
        Student s = new Student(studentName, name, year);
        if(students.contains(s)) {
            return false;
        } else {
            students.add(s);
            return true;
        }
    }

// ???
    public boolean showStudentsList() {
        students.sort(this.NameComparator);
        if(students.isEmpty()) {
            System.out.println("The list of students is empty.");
            return false;
        } else {
            System.out.println("The list of students:");
            Iterator<Student> iter = students.iterator();
            for(int i = 1; iter.hasNext(); i++){
                System.out.println(i + ". " + iter.next().getName());
            }
            return true;
        }
    }

    public Student getStudent(int i) throws EmptyListException {
        if (students.isEmpty()) {
            throw new EmptyListException(students.toString());
        } else if (i < 0 || i > students.size()) {
            throw new IndexOutOfBoundsException(i);
        }
        return students.get(i);
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return name + ", year: " + year;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + year + students.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Group) {
            Group anobj = (Group)obj;
            return this.year == anobj.year
                    & this.name.equals(anobj.name)
                    & this.students.equals(anobj.students);
        }
        return false;
    }
}
