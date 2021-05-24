package com.company.services.interfaces.inanimate.subject;

import com.company.domain.inanimate.subject.ListHasStudents;
import com.company.domain.inanimate.subject.Subject;
import com.company.domain.people.Student;
import com.company.services.interfaces.Common;

import java.util.Date;
import java.util.Map;

public interface ListHasStudentsService extends Common<ListHasStudents> {
//    void addAttestations(Map<ListHasStudents, Boolean> mapAttest);
    void addFirstAttest(long listHasStudentsId, boolean attest);
    void addSecondAttest(long listHasStudentsId, boolean attest);
}
