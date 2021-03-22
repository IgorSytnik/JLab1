package com.company.domain.people;

import com.company.domain.ClassWithName;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Subject extends ClassWithName {

//    @id
    private long id;

//    @id
    private final long idGroup;

    private final List<Work> works = new ArrayList<>();

    public Subject(String name, long idGroup) {
        this.name = name;
        this.idGroup = idGroup;
    }

}
