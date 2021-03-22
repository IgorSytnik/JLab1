package com.company.domain.people;

import com.company.domain.ClassWithName;
import com.company.exceptoins.EmptyListException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public class Group extends ClassWithName {

    private long id;
    private final List<Student> students = new ArrayList<>();
    private final List<Subject> subjects = new ArrayList<>();
    private int year;

    public Group(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public boolean addStudent(String studentName) {
        if (studentName == null) {
            throw new IllegalArgumentException("studentName must not be null");
        }
        Student student = new Student(studentName, name, subjects);
        if(students.contains(student)) {
            return false;
        } else {
            students.add(student);
            return true;
        }
    }

    public boolean addSubject(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("subject must not be null");
        }
        if(subjects.contains(subject)) {
            return false;
        } else {
            subjects.add(subject);
            return true;
        }
    }

    public long getId() {
        return id;
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

//    /**
//     * @return copy of student list
//     * */
//    public List<Student> getStudents() {
//        return List.copyOf(students);
//    }

//    public int getYear() {
//        return year;
//    }

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
