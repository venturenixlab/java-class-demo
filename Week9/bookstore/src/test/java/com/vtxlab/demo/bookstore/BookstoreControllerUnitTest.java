package com.vtxlab.demo.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vtxlab.demo.bookstore.controller.BookOperation;
import com.vtxlab.demo.bookstore.controller.impl.BookController;
import com.vtxlab.demo.bookstore.entity.Book;
import com.vtxlab.demo.bookstore.service.BookService;

@ExtendWith(SpringExtension.class) // @Mock, @MockBean, @InjectMocks
public class BookstoreControllerUnitTest {

  @Mock
  BookService bookService;

  // @InjectMocks
  BookOperation bookOperation;

  @BeforeEach
  void setup() {
    bookOperation = new BookController(bookService);
  }

  private void testControllerFindAllBooks(List<Book> booksFromService, int size) {
    // Builder to build a book
    // given (Mock)
    when(bookService.findAllBooks()).thenReturn(booksFromService);
    // when 
    List<Book> books = bookOperation.findAllBooks();
    // then
    assertThat(books).hasSize(size);
  //  assertThat(books.get(0).getBookName()).isNull();
  //  assertThat(books.get(1).getBookName()).isNull();
  }

  @Test
  void testCaseForFindAllBooks() {
    testControllerFindAllBooks(List.of(new Book(), new Book()), 2);
    testControllerFindAllBooks(List.of(new Book()), 1);
    testControllerFindAllBooks(new ArrayList<>(), 0);
  }

}
