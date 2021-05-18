package com.company.domain.inanimate.subject;

import com.company.domain.ClassWithName;
import com.company.domain.inanimate.Group;
import com.company.domain.inanimate.StudentsHasWorks;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Entity
@Table(name = "works")
public class Work extends ClassWithName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "term", nullable = false)
    @Temporal(TemporalType.DATE)
    private final Date term;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @OneToMany(mappedBy = "primaryKey.work",
            cascade = CascadeType.ALL)
    private List<StudentsHasWorks> StudentsHasWorksList = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Work that = (Work) o;
        return Objects.equals(term, that.term) &&
                Objects.equals(name, that.name) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(term, name, subject, group);
    }
}
