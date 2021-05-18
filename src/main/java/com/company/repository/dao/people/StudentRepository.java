package com.company.repository.dao.people;

import com.company.domain.people.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Override
//    public Student findById(long id) {
//        return null;
//    }
//
//    @Override
//    public List<Student> findAll() {
//        return null;
//    }
//
//    @Override
//    public Student save(Student student) {
//        return null;
//    }
//
//    @Override
//    public Student update(Student student) {
//        return null;
//    }
//
//    @Override
//    public Student delete(Student student) {
//        return null;
//    }
}
