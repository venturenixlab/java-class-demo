package com.vtxlab.demo.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vtxlab.demo.student.entity.Student;

@Repository // -> bean = studentRepository
// @Repository is a kind of @Component
public interface StudentRepository extends JpaRepository<Student, Long> {

  List<Student> findByNameAndHeight(String name, Double height);

  @Query(nativeQuery = true
      , value = "inesrt into students (name, height) values (:name, :height)")
  Void createStudent(@Param("name") String name, @Param("height") Double height);
}
