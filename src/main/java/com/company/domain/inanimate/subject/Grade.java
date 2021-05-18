package com.company.domain.inanimate.subject;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "grades", uniqueConstraints =
    @UniqueConstraint(columnNames = {"grade_dates_id", "list_has_students_id"})
)
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "grade", nullable = false)
    private int grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_dates_id", nullable = false)
    private GradeDate gradeDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_has_students_id", nullable = false)
    private ListHasStudents listHasStudents;
}
