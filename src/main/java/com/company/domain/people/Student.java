package com.company.domain.people;

import com.company.domain.ClassWithName;

import java.util.*;

public class Student extends ClassWithName {

    private long id;
    private Map<Subject, SubjectAttest> subjects = new HashMap<>();
    private String group;

    public Student(String name, String group, List<Subject> subjectList) {
        this.name = name;
        this.group = group;
        for (Subject subject:
             subjectList) {
            subjects.put(subject, new SubjectAttest());
        }
    }

    /**
     * @return copy of subject list
     * */
    public HashMap<Subject, SubjectAttest> getSubjects() {
        return (HashMap<Subject, SubjectAttest>) Map.copyOf(subjects);
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
