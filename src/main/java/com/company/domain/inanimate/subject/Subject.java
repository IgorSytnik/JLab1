package com.company.domain.inanimate.subject;

import com.company.domain.ClassWithName;
import com.company.domain.inanimate.GroupsSubjects;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "subjects")
public class Subject extends ClassWithName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    protected String name;

    @OneToMany(mappedBy = "subject", orphanRemoval = false)
    private final List<Work> works = new ArrayList<>();

    @OneToMany(mappedBy = "subject",
            cascade = CascadeType.ALL)
    private List<GroupsSubjects> groupsSubjects = new ArrayList<>();

}
