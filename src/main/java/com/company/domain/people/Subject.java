package com.company.domain.people;

import com.company.domain.ClassWithName;

public class Subject extends ClassWithName {

    private long id;

    public Subject(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

}
