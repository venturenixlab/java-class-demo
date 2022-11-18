package com.vtxlab.demo.post.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Posts")
public class Post {
  @Id
  private Long id;

  @Column(name = "content")
  private String content;
  
  @Column(name = "title")
  private String title;
  // getter, setter, constructor ...
}
