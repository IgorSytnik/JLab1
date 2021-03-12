package com.company.domain.people;

import com.company.domain.ClassWithName;

import java.util.ArrayList;
import java.util.List;

public class Student extends ClassWithName {
    private List<Subject> subjects;
    private String group;

    public Student(String name, String group, List<Subject> subjectList) {
        this.name = name;
        this.group = group;
        this.subjects = new ArrayList<>(subjectList);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return name + ", group: " + group;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + group.hashCode() + subjects.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Student) {
            Student anobj = (Student)obj;
            return this.name.equals(anobj.name)
                    & this.group.equals(anobj.group)
                    & this.subjects.equals(anobj.subjects);
        }
        return false;
    }
}
