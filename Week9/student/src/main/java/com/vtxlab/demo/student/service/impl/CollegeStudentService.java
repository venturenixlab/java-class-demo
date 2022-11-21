package com.vtxlab.demo.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.student.entity.Student;
import com.vtxlab.demo.student.repository.StudentRepository;
import com.vtxlab.demo.student.service.StudentService;

@Service // Bean collegeStudentService -> Spring Container
public class CollegeStudentService implements StudentService {

  @Autowired
  // if no qualifier and there is only class implement the interface
  // the object reference name is not important for finding the bean
  StudentRepository studentRepository;

  @Autowired // if there is qualifier, Qualifier value = bean name
  @Qualifier(value = "beanForAlan")
  Student studentForAlan;

  @Autowired // if there is qualifier, Qualifier value = bean name
  @Qualifier(value = "beanForVincent")
  Student studentForVincent;

  public List<Student> findStudents() {
    return studentRepository.findAll();
  }

  public Void createStudent(String name, Double height) {
    return studentRepository.createStudent(name, height);
  }
}
