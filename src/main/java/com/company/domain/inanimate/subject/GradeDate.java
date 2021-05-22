package com.company.domain.inanimate.subject;

import com.company.domain.inanimate.GroupsSubjects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "grade_dates", uniqueConstraints =
        @UniqueConstraint(columnNames = {"groups_subjects_id", "date"})
)
public class GradeDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumns({
//            @JoinColumn(name = "subject_list_groups_id", referencedColumnName = "groups_id"),
//            @JoinColumn(name = "subject_list_subjects_id", referencedColumnName = "subjects_id")
//    })
//    private GroupsSubjects groupsSubjects;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "groups_subjects_Id", nullable = false)
    private GroupsSubjects groupsSubjects;

    @OneToMany(mappedBy = "gradeDate")
    private List<Grade> grades = new ArrayList<>();

    public GradeDate(Date date, GroupsSubjects groupsSubjects) {
        this.date = date;
        this.groupsSubjects = groupsSubjects;
    }

}
