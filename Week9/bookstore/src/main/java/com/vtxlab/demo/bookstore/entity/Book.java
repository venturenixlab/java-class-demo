package com.vtxlab.demo.bookstore.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOKS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

  @Id // PRIMARY KEY
  private Long id;

  @Column(name = "AUTHOR_NAME") // TABLE COLUMN
  private String authorName;

  @Column(name = "BOOK_NAME")
  private String bookName;

  @Column(name = "PUBLIC_DATE")
  private LocalDate publicDate;

}
