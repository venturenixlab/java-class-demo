package com.vtxlab.demo.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  @Id
  private Long Id;

  @Column(name = "height")
  private Double height;

  @Column(name = "name")
  private String name;

}
