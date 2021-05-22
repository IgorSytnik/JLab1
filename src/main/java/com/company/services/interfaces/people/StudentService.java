package com.company.services.interfaces.people;

import com.company.domain.inanimate.Group;
import com.company.domain.inanimate.subject.Grade;
import com.company.domain.inanimate.subject.ListHasStudents;
import com.company.domain.people.Student;
import com.company.domain.inanimate.subject.Subject;
import com.company.domain.inanimate.subject.Work;
import com.company.services.interfaces.Common;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentService extends Common<Student> {
//    void addAttestations(Map<Student, Boolean> mapAttest, Subject subject);
    Collection<Grade> getGrades(Student student, Subject subject);
    Collection<ListHasStudents> getAttestations(Student student, Subject subject);
//    boolean handOverWork (Work work, String file, Student student);
}
