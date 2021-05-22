package com.company.domain.inanimate;

import com.company.domain.ClassWithName;
import com.company.domain.hei.Department;
import com.company.domain.inanimate.subject.Work;
import com.company.domain.people.Student;
import com.company.exceptoins.EmptyListException;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "groups")
public class Group extends ClassWithName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "year", nullable = false)
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialty_id", nullable = false)
    private Specialty specialty;

    @OneToMany(mappedBy = "group")
    private final List<Student> students = new ArrayList<>();

//    @OneToMany(mappedBy = "group", orphanRemoval = false)
//    private List<Work> works = new ArrayList<>();

    @OneToMany(mappedBy = "group")
    private List<GroupsSubjects> groupsSubjects = new ArrayList<>();

    public Group(String name, int year, Department department, Specialty specialty) {
        this.name = name;
        this.year = year;
        this.department = department;
        this.specialty = specialty;
    }

    // TODO: 22.05.2021 shouldn't be here
    public Group(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public boolean addStudent(@NonNull Student student) {
//        Student student = new Student(studentName, name, subjects);
        if(students.contains(student)) {
            return false;
        } else {
            students.add(student);
            student.setGroup(this);
            return true;
        }
    }

    // ???
    /*public boolean showStudentsList() {
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
    }*/

    public Student getStudent(int i) throws EmptyListException {
        if (students.isEmpty()) {
            throw new EmptyListException(students.toString());
        } else if (i < 0 || i > students.size()) {
            throw new IndexOutOfBoundsException(i);
        }
        return students.get(i);
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
