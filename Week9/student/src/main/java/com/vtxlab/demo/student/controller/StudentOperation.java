package com.vtxlab.demo.student.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.student.entity.Student;

@RequestMapping(value = "/default")
public interface StudentOperation {

  @GetMapping(value = "/students")
  ResponseEntity<List<Student>> findStudents();

  @PostMapping(value = "/student/name/{name}/height/{height}")
  ResponseEntity<Void> createStudent(@PathVariable String name,
      @PathVariable Double height);

}
