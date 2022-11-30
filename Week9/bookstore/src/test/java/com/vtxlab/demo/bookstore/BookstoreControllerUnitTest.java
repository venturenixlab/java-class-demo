package com.vtxlab.demo.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.authenticator.jaspic.AuthConfigFactoryImpl;
import org.assertj.core.api.LocalDateAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.vtxlab.demo.bookstore.controller.BookOperation;
import com.vtxlab.demo.bookstore.controller.impl.BookController;
import com.vtxlab.demo.bookstore.entity.Author;
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

  private void testFindAllBooks(List<Book> booksFromService, int size) {
    // Builder to build a book
    // given (Mock)
    when(bookService.findAllBooks()).thenReturn(booksFromService);
    // when 
    List<Book> books = bookOperation.findAllBooks();
    // then
    assertThat(books).hasSize(size);
    //assertThat(books.get(0).getBookName()).isNull();
    //assertThat(books.get(1).getBookName()).isNull();
  }

  @Test
  void testCaseForFindAllBooks() {
    testFindAllBooks(List.of(new Book(), new Book()), 2);
    testFindAllBooks(List.of(new Book()), 1);
    testFindAllBooks(new ArrayList<>(), 0);
  }

  private void testFindBookById(Book book, Long id) {
    // Given
    when(bookService.findBookById(anyLong())).thenReturn(Optional.ofNullable(book));
    // when
    ResponseEntity<Book> aBook = bookOperation.findBookById(id);
    // then
    if (book != null) {
      assertThat(aBook.getBody().getBookName()).isEqualTo(book.getBookName());
      assertThat(aBook.getBody().getId()).isEqualTo(book.getId());
      assertThat(aBook.getBody().getPublicDate()).isEqualTo(book.getPublicDate());
    } else {
      assertThat(aBook.getBody()).isEqualTo(null);
    }
  }

  @Test
  void testCaseForFindBookById() {
    testFindBookById(null, 1l);
    testFindBookById(
        new Book(2l, "Tommy Book", LocalDate.of(2022, 10, 2), new Author()),
        2l);
  }

  private void testCreateBook(Book book, Book returnBook) {
    // Given
    when(bookService.createBook(book)).thenReturn(returnBook);
    // when
    ResponseEntity<Book> newBook = bookOperation.createBook(book);
    // then
    if (returnBook != null) {
      assertThat(returnBook.getBookName()).isEqualTo(newBook.getBody().getBookName());
      assertThat(newBook.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    } else {
      assertThat(newBook.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
  }

  @Test
  void testCaseForCreateBook() {
    Book book = new Book(1l, "Steve Book", LocalDate.of(2022, 11, 30),
        new Author());

    // testCreateBook(book, null); // key exists, creation is not required
    // testCreateBook(book, book); // creation success
  }

  private void testDeleteBookById(Long id, Book returnBook) {
    // Given
    when(bookService.deleteBookById(anyLong())).thenReturn(returnBook);
    // when
    ResponseEntity<Book> controllerReturnBook = bookOperation.deleteBookByid(id);
    // then
    if (returnBook != null) {
      // assertThat(controllerReturnBook.getBody().getId()).isEqualTo(id);
      assertThat(controllerReturnBook.getBody().getId()).isEqualTo(returnBook.getId());
      assertThat(controllerReturnBook.getStatusCode()).isEqualTo(HttpStatus.OK);
    } else {
      assertThat(controllerReturnBook.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
  }

  @Test
  void testCaseForDeleteBookById() {
    testDeleteBookById(1l, null);
    testDeleteBookById(2l,
        new Book(2l, "Vincent Book", LocalDate.of(2000, 1, 20), new Author()));
  }
}
