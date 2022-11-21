package com.vtxlab.demo.student.service;

import java.util.List;

import com.vtxlab.demo.student.entity.Student;

public interface StudentService {

  List<Student> findStudents();

  Void createStudent(String name, Double height);

}
