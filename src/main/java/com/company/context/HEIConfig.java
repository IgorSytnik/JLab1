package com.company.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"com.company.controllers", "com.company.services", "com.company.repository", "com.company.domain"})
@Import(HibernateConfig.class)
public class HEIConfig {

//    @Bean
//    public GroupService groupService() {
//        return new GroupServiceImpl( groupRepository() );
//    }
//
//    @Bean
//    public SubjectService subjectService() {
//        return new SubjectServiceImpl( subjectRepository() );
//    }
//
//    @Bean
//    public StudentService studentService() {
//        return new StudentServiceImpl( studentRepository() );
//    }
//
//    @Bean
//    public WorkService workService() {
//        return new WorkServiceImpl( workRepository() );
//    }
//
//    @Bean
//    public RepositoryInt groupRepository() {
//        return new GroupRepository();
//    }
//
//    @Bean
//    public RepositoryInt subjectRepository() {
//        return new SubjectRepository();
//    }
//
//    @Bean
//    public RepositoryInt studentRepository() {
//        return new StudentRepository();
//    }
//
//    @Bean
//    public RepositoryInt workRepository() {
//        return new WorkRepository();
//    }
}
