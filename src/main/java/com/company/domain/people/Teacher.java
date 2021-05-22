package com.company.domain.people;

import com.company.domain.ClassWithName;
import com.company.domain.hei.Department;
import com.company.domain.inanimate.GroupsSubjects;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
public class Teacher extends ClassWithName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "position", nullable = false)
    private AcademicPosition position;

    @OneToMany(mappedBy = "teacher")
    private List<GroupsSubjects> groupsSubjects = new ArrayList<>();

    public Teacher(String name, AcademicPosition position, Department department) {
        this.name = name;
        this.position = position;
        this.department = department;
    }

    /**
     * Example:
     * David Newberg, position: Aspirant */
    @Override
    public String toString() {
        return name + ", position: " + position;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + position.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Teacher) {
            Teacher anobj = (Teacher)obj;
            return this.name.equals(anobj.name)
                    & this.position.equals(anobj.position);
        }
        return false;
    }
}
