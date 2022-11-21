package com.vtxlab.demo.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtxlab.demo.student.entity.Student;

@Repository // -> bean = studentRepository
// @Repository is a kind of @Component
public interface StudentRepository extends JpaRepository<Student, Long> {

  List<Student> findByNameAndHeight(String name, Double height);

}
