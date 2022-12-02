package com.vtxlab.demo.bookstore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AUTHORS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Serializable {

  private static final long serialVersionUID = 4750079787174869458L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "AUTHOR_NAME")
  private String authorName;

  @Column(name = "AUTHOR_NAT")
  private String nationality;

  @OneToMany(mappedBy = "author", // default LAZY
      cascade = CascadeType.ALL //
  )
  @JsonIgnoreProperties({ "author" })
  private List<Book> books = new ArrayList<>();

  public void addBook(Book book) {
    this.books.add(book);
  }

  public Author(Long id, String authorName, String nationality) {
    this.id = id;
    this.authorName = authorName;
    this.nationality = nationality;
  }

}
