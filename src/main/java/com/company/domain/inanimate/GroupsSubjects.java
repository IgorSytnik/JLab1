package com.company.domain.inanimate;

import com.company.domain.inanimate.subject.GradeDate;
import com.company.domain.inanimate.subject.ListHasStudents;
import com.company.domain.inanimate.subject.Subject;
import com.company.domain.people.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "groups_subjects", uniqueConstraints =
    @UniqueConstraint(columnNames = {"groups_id", "subjects_id"})
)
//@AssociationOverrides({
//        @AssociationOverride(name = "primaryKey.group",
//                joinColumns = @JoinColumn(name = "groups_id")),
//        @AssociationOverride(name = "primaryKey.subject",
//                joinColumns = @JoinColumn(name = "subjects_id"))
//})
@Getter
@Setter
public class GroupsSubjects {

//    @EmbeddedId
//    private GroupsSubjectId primaryKey;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "groups_id", nullable = false)
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "subjects_id", nullable = false)
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teachers_id", nullable = false)
    private Teacher teacher;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupsSubjects")
    private List<GradeDate> gradeDateList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupsSubjects")
    private List<ListHasStudents> listHasStudentsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        GroupsSubjects that = (GroupsSubjects) o;
        return Objects.equals(teacher, that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacher);
    }

    // inner class defined for primary key(composite keys)
    /*@Embeddable
    @Getter
    public static class GroupsSubjectId {

//        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//        @JoinColumn(name = "groups_id")
        @Column(name = "groups_id")
        private Group group;
//        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//        @JoinColumn(name = "subjects_id")
        @Column(name = "subjects_id")
        private Subject subject;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass())
                return false;

            GroupsSubjectId that = (GroupsSubjectId) o;
            return Objects.equals(group, that.group) &&
                    Objects.equals(subject, that.subject);
        }

        @Override
        public int hashCode() {
            return Objects.hash(group, subject);
        }
    }*/
}
