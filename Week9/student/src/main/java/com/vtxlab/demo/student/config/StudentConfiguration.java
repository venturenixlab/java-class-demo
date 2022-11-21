package com.vtxlab.demo.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vtxlab.demo.student.entity.Student;

@Configuration
public class StudentConfiguration {

  @Bean(name = "beanForAlan")
  public Student getAlan() {
    return new Student(2l, 155.0d, "alan");
  }
}
