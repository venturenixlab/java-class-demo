package com.vtxlab.demo.bookstore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AUTHORS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "AUTHOR_NAME")
  private String authorName;

  @Column(name = "AUTHOR_NAT")
  private String nationality;

  @OneToMany(mappedBy = "author", // default LAZY
      cascade = CascadeType.PERSIST, //
      orphanRemoval = true)
  private List<Book> books;

}
