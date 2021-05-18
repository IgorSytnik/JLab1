package com.company.run;

import com.company.context.HEIConfig;
import com.company.controllers.hei.DepartmentController;
import com.company.controllers.people.StudentController;
import com.company.controllers.people.TeacherController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class Main {
    public static void main(String[] args) {

        // TODO: 17.05.2021 profiles and stuff 
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HEIConfig.class);
        final ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println("Active profile: " + environment.getProperty("spring.profiles.active"));
        final DepartmentController departmentController = context.getBean(DepartmentController.class);
//        StudentController studentController = context.getBean(StudentController.class);
//        TeacherController teacherController = context.getBean(TeacherController.class);

    }
}
