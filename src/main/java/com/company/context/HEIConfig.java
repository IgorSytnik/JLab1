package com.company.context;

import com.company.repository.dao.people.GroupRepository;
import com.company.repository.dao.people.StudentRepository;
import com.company.repository.dao.people.SubjectRepository;
import com.company.repository.dao.people.WorkRepository;
import com.company.repository.interfaces.RepositoryInt;
import com.company.services.interfaces.people.GroupService;
import com.company.services.interfaces.people.StudentService;
import com.company.services.interfaces.people.SubjectService;
import com.company.services.interfaces.people.WorkService;
import com.company.services.people.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.company.controllers", "com.company.services", "com.company.repository"})
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
