package com.vtxlab.demo.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vtxlab.demo.bookstore.entity.Author;
import com.vtxlab.demo.bookstore.entity.Book;
import com.vtxlab.demo.bookstore.repository.BookRepository;
import com.vtxlab.demo.bookstore.service.BookService;
import com.vtxlab.demo.bookstore.service.impl.EBookService;

@ExtendWith(SpringExtension.class)
public class BookstoreServiceUnitTest {

  @Mock
  BookRepository bookRepository;

  BookService bookService;

  @BeforeEach
  void setup() {
    bookService = new EBookService(bookRepository);
  }

  @Test
  void testFindAllBooks() {
    // book1
    Book book = new Book(1l, "Vincent's Book", LocalDate.of(2011, 10, 9),
        new Author());
    // book2
    Book book2 = new Book(1l, "Vincent's Book", LocalDate.of(2011, 10, 9),
        new Author());
    // Given
    when(bookRepository.findAll()).thenReturn(List.of(book2, book));
    // when
    List<Book> books = bookService.findAllBooks();
    // then
    assertThat(books).hasSize(2);
  }

}
