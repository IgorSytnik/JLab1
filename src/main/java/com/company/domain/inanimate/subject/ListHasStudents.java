package com.company.domain.inanimate.subject;

import com.company.domain.inanimate.Group;
import com.company.domain.inanimate.GroupsSubjects;
import com.company.domain.people.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Table(name = "list_has_students", uniqueConstraints =
    @UniqueConstraint(columnNames = {"groups_subjects_Id", "students_id"})
)
public class ListHasStudents {

//    @EmbeddedId
//    private ListHasStudentsId primaryKey;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "groups_subjects_Id", nullable = false)
    private GroupsSubjects groupsSubjects;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "students_id", nullable = false)
    private Student student;

    @Setter
    @Column(name = "attestation_first", columnDefinition = "TINYINT(1)")
    private Boolean attest1;

    @Setter
    @Column(name = "attestation_second", columnDefinition = "TINYINT(1)")
    private Boolean attest2;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listHasStudents")
    private List<Grade> grades;

    public void addAttest(boolean attest) {
        if (attest1 == null) {
            attest1 = attest;
        } else {
            attest2 = attest;
        }
    }

    public ListHasStudents(GroupsSubjects groupsSubjects, Student student) {
        this.groupsSubjects = groupsSubjects;
        this.student = student;
    }
// inner class defined for primary key(composite keys)
    /*@Embeddable
    @Getter
    public static class ListHasStudentsId {

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumns({
                @JoinColumn(name = "subject_list_groups_id", referencedColumnName = "groups_id"),
                @JoinColumn(name = "subject_list_subjects_id", referencedColumnName = "subjects_id")
        })
        private GroupsSubjects groupsSubjects;

//        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//        @JoinColumn(name = "students_id")
        @Column(name = "students_id")
        private Student student;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass())
                return false;

            ListHasStudentsId that = (ListHasStudentsId) o;
            return Objects.equals(groupsSubjects, that.groupsSubjects) &&
                    Objects.equals(student, that.student);
        }

        @Override
        public int hashCode() {
            return Objects.hash(groupsSubjects, student);
        }
    }*/
}
