package com.company.domain.inanimate;

import com.company.domain.inanimate.subject.Work;
import com.company.domain.people.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "students_has_works")
//@AssociationOverrides({
//        @AssociationOverride(name = "primaryKey.student",
//                joinColumns = @JoinColumn(name = "student_id")),
//        @AssociationOverride(name = "primaryKey.work",
//                joinColumns = @JoinColumn(name = "work_id"))
//})
@Getter
@Setter
public class StudentsHasWorks {

    @EmbeddedId
    private StudentWorkId primaryKey = new StudentWorkId();

    @Column(name = "delivery_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date deliveryDate = new Date();

    @Column(name = "ready_work_link", nullable = false)
    private String workLink;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        StudentsHasWorks that = (StudentsHasWorks) o;
        return Objects.equals(deliveryDate, that.deliveryDate) &&
                Objects.equals(workLink, that.workLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryDate, workLink);
    }

    // inner class defined for primary key(composite keys)
    @Embeddable
    @Getter
    @Setter
    public static class StudentWorkId implements Serializable {

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "students_id", nullable = false)
        private Student student;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "works_id", nullable = false)
        private Work work;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass())
                return false;

            StudentWorkId that = (StudentWorkId) o;
            return Objects.equals(student, that.student) &&
                    Objects.equals(work, that.work);
        }

        @Override
        public int hashCode() {
            return Objects.hash(student, work);
        }
    }
}
