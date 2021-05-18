package com.company.domain.people;

import com.company.domain.ClassWithName;
import com.company.domain.inanimate.Group;
import com.company.domain.inanimate.StudentsHasWorks;
import com.company.domain.inanimate.subject.ListHasStudents;
import com.company.domain.inanimate.subject.Subject;
import com.company.domain.inanimate.subject.Work;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Table(name = "students")
public class Student extends ClassWithName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    @Setter
    private Group group;

    @OneToMany(mappedBy = "primaryKey.student",
            cascade = CascadeType.ALL)
    private List<StudentsHasWorks> StudentsHasWorksList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<ListHasStudents> listHasStudentsList;

    public Student(String name, Group group, List<Subject> subjectList) {
        this.name = name;
        this.group = group;
//        for (Subject subject:
//             subjectList) {
//            subjects.put(subject, new SubjectAttest());
//        }
    }
    /*public Student(String name, String groupName, List<Subject> subjectList) {
        this.name = name;
        this.groupName = groupName;
//        for (Subject subject:
//                subjectList) {
//            subjects.put(subject, new SubjectAttest());
//        }
    }*/
    public Student(String name) {
        this.name = name;
    }

    public boolean handOverWork(Work work, String file) {
        StudentsHasWorks studentsHasWorks = new StudentsHasWorks();
        studentsHasWorks.setDeliveryDate(new Date(System.currentTimeMillis()));
        studentsHasWorks.setWorkLink(file);
        studentsHasWorks.getPrimaryKey().setStudent(this);
        studentsHasWorks.getPrimaryKey().setWork(work);
        return StudentsHasWorksList.add(studentsHasWorks);
    }

//    @Override
//    public String toString() {
//        return name + ", group: " + group;
//    }
//
//    @Override
//    public int hashCode() {
//        return name.hashCode() + group.hashCode() + subjects.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this.hashCode() != obj.hashCode()) {
//            return false;
//        }
//        if (obj instanceof Student) {
//            Student anobj = (Student)obj;
//            return this.name.equals(anobj.name)
//                    & this.group.equals(anobj.group)
//                    & this.subjects.equals(anobj.subjects);
//        }
//        return false;
//    }
    @Override
    public String toString() {
        return name + ", group: " + group;
    }

//    @Override
//    public int hashCode() {
//        return name.hashCode();
//    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Student) {
            Student anobj = (Student)obj;
            return this.name.equals(anobj.name)
                    & this.group.equals(anobj.group)
//                    & this.subjects.equals(anobj.subjects)
                    ;
        }
        return false;
    }
}
