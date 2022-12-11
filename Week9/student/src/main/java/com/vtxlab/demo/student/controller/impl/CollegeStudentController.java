package com.vtxlab.demo.student.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.student.controller.StudentOperation;
import com.vtxlab.demo.student.entity.Student;
import com.vtxlab.demo.student.service.StudentService;

@RestController // Controller + ResponseBody
@RequestMapping(value = "/api/v1")
public class CollegeStudentController implements StudentOperation {

  @Autowired // = new collegeStudentService();
  StudentService studentService;

  @Override
  public ResponseEntity<List<Student>> findStudents() {
    return ResponseEntity.ok().body(studentService.findStudents()); // ok -> 200
  }

  @Override
  public ResponseEntity<Void> createStudent(String name, Double height) {
    studentService.createStudent(name, height);
    return ResponseEntity.noContent().build(); // noContent() -> 204
  }

}
