package com.company.run;

import com.company.context.HEIConfig;
import com.company.controllers.hei.DepartmentController;
import com.company.controllers.hei.FacultyController;
import com.company.controllers.people.StudentController;
import com.company.controllers.people.TeacherController;
import com.company.domain.hei.Department;
import com.company.domain.hei.Faculty;
import com.company.domain.inanimate.Group;
import com.company.domain.people.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class Main {
    public static void main(String[] args) {

        // TODO: 17.05.2021 profiles and stuff 
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HEIConfig.class);
        final ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println("Active profile: " + environment.getProperty("spring.profiles.active"));

        final FacultyController facultyController = context.getBean(FacultyController.class);
        final DepartmentController departmentController = context.getBean(DepartmentController.class);

        System.out.println();
        facultyController.deleteAllFaculties();

        facultyController.makeFaculty("TEF1");
        facultyController.makeFaculty("TEF2");
        facultyController.makeFaculty("TEF3");

        for (Faculty faculty : facultyController.getAllFaculties()) {
            System.out.println(faculty);
        }

//        System.out.println();
//
//        facultyController.makeDepartment("APEPS");
//
//        for (Department department :
//                departmentController.getAllDepartments()) {
//            System.out.println(faculty);
//        }

//        final DepartmentController departmentController = context.getBean(DepartmentController.class);
//        departmentController.makeGroup("TV-81", 3);
//        for (Group g :
//                departmentController.getAllGroups()) {
//            System.out.println(g.getName());
//        }
//        departmentController.makeStudent("Goga Pulli", );
//        departmentController.makeStudent("Nash si-Iperr");
//        for (Student s :
//             departmentController.getAllStudents()) {
//            System.out.println(s.getName());
//        }
//        StudentController studentController = context.getBean(StudentController.class);
//        TeacherController teacherController = context.getBean(TeacherController.class);

    }
}
