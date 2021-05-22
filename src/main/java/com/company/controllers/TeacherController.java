package com.company.controllers;

import com.company.domain.inanimate.GroupsSubjects;
import com.company.domain.inanimate.subject.Grade;
import com.company.domain.inanimate.subject.GradeDate;
import com.company.domain.inanimate.subject.ListHasStudents;
import com.company.domain.inanimate.subject.Work;
import com.company.services.interfaces.inanimate.GroupsSubjectsService;
import com.company.services.interfaces.inanimate.subject.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class TeacherController {

    private final GradeDateService gradeDateService;
    private final GroupsSubjectsService groupsSubjectsService;
    private final GradeService gradeService;
    private final ListHasStudentsService listHasStudentsService;
    private final WorkService workService;

    /*Map: long groupsSubjectsId, Date gradeDate*/
    public Collection<GradeDate> makeGradeDates(Map<Long, List<Date>> dateMap) {
        List<GradeDate> gradeDateList = new LinkedList<>();
        dateMap.forEach((groupsSubjectsId, gradeDate) -> gradeDate.forEach(d ->
                        gradeDateList.add(new GradeDate(d, groupsSubjectsService.findById(groupsSubjectsId))))
        );
        return gradeDateService.makeMany(gradeDateList);
    }

    /*Map: String name, Date term*/
    public Collection<Work> makeWorks(List<Map.Entry<String, Date>> workMap, long groupsSubjectsId) {
        GroupsSubjects groupsSubjects = groupsSubjectsService.findById(groupsSubjectsId);
        return workService.makeMany(workMap.stream()
                .collect(
                        LinkedList::new,
                        (list, entry) -> list.add(new Work(
                                entry.getKey(),
                                entry.getValue(),
                                groupsSubjects)),
                        LinkedList::addAll));
    }

    /*Map: long listHasStudentsId, boolean attest*/
    public void giveAttestations(Map<Long, Boolean> mapAttest) {
        listHasStudentsService.addAttestations(mapAttest.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> listHasStudentsService.findById(e.getKey()),
                        Map.Entry::getValue)));
    }

    /*Map: long listHasStudentsId, long gradeDateId, int grade*/
    public Collection<Grade> giveGrades(Map<Long, Map<Long, Integer>> mapGrades) {
        List<Grade> gradeList = new LinkedList<>();
        mapGrades.forEach((listHasStudentsId, v) -> v.forEach((gradeDateId, grade) ->
                gradeList.add(new Grade(grade,
                        gradeDateService.findById(gradeDateId),
                        listHasStudentsService.findById(listHasStudentsId))))
        );
        return gradeService.makeMany(gradeList);
    }

    public Collection<ListHasStudents> getStudentList(long groupsSubjectsId) {
        return groupsSubjectsService.findById(groupsSubjectsId).getListHasStudentsList();
    }

    public Collection<GradeDate> getGradeDatesList(long groupsSubjectsId) {
        return groupsSubjectsService.findById(groupsSubjectsId).getGradeDateList();
    }
}
