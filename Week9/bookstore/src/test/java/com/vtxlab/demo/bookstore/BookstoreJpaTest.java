package com.vtxlab.demo.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vtxlab.demo.bookstore.entity.Author;
import com.vtxlab.demo.bookstore.entity.Book;
import com.vtxlab.demo.bookstore.repository.AuthorRepository;
import com.vtxlab.demo.bookstore.repository.BookRepository;

@DataJpaTest // Only create those Beans related to JPA
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ExtendWith(SpringExtension.class)
public class BookstoreJpaTest {

  @Autowired
  BookRepository bookRepository;

  @Autowired
  AuthorRepository authorRepository;

  @Autowired
  EntityManager entityManager;

  @BeforeEach
  void setup() {
    // bookRepository.save(book2);
  }

  @Test
  void testFindAll() {

    Book book1 = new Book("Vincent Book", LocalDate.of(2022, 1, 1));
    // null);
    // Book book2 = new Book(7l, "Tommy Book", LocalDate.of(2022, 2, 1), null);
    Author author = new Author(1l, "Vincent", "HK");
    author.addBook(book1);
    //author = authorRepository.save(author);
    // book1.setAuthor(author);
    // book2.setAuthor(author);
    // entityManager.persist(book1);
    // entityManager.persist(book2);
    // bookRepository.saveAndFlush(book1);
    // when
    // List<Book> books = bookRepository.findAll();
    // then
    assertThat(author.getBooks()).hasSize(1);
  }

}
