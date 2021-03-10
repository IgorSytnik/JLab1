package com.company.domain.people;

import com.company.domain.ClassWithName;

public class Student extends ClassWithName {
    private String group;
    private int year;

    public Student(String n, String g, int y) {
        this.name = n;
        this.group = g;
        this.year = y;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return name + ", group: " + group + ", year: " + year;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + year + group.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Student) {
            Student anobj = (Student)obj;
            return this.year == anobj.year
                    & this.name.equals(anobj.name)
                    & this.group.equals(anobj.group);
        }
        return false;
    }
}
