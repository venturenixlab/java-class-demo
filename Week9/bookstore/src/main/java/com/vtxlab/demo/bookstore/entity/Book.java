package com.vtxlab.demo.bookstore.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOKS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

  private static final long serialVersionUID = 4750079787174869458L;

  @Id // PRIMARY KEY
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "BOOK_NAME")
  private String bookName;

  @Column(name = "PUBLIC_DATE")
  private LocalDate publicDate;

  @ManyToOne(cascade = CascadeType.ALL)
  // @JoinColumn(name = "AUTHOR_ID") // FK
  @JoinColumn(name = "author_id", referencedColumnName = "id")
  @JsonIgnoreProperties("books")
  private Author author; //

  public Book(String bookName, LocalDate publicDate) {
    this.bookName = bookName;
    this.publicDate = publicDate;
  }

}
