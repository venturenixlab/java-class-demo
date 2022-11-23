package com.vtxlab.demo.bookstore.controller.impl;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vtxlab.demo.bookstore.controller.BookOperation;
import com.vtxlab.demo.bookstore.entity.Book;
import com.vtxlab.demo.bookstore.service.BookService;

@RequestMapping(value = "/api/v1")
@RestController
public class BookController implements BookOperation {

  @Autowired
  BookService bookService;

  @Override
  public List<Book> findAllBooks() {
    return bookService.findAllBooks();
  }

  @Override
  public ResponseEntity<Book> findBookById(Long id) {
    // return bookService.findBookById(id).orElse(null);
    Optional<Book> oBook = bookService.findBookById(id);
    if (oBook.isPresent()) {
      return ResponseEntity.ok().body(oBook.get()); //
    }
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Book> createBook(Book book) {
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .buildAndExpand()
        .toUri();

    Book rtnBook = bookService.createBook(book);
    if (rtnBook != null) {
      return ResponseEntity.created(location).body(rtnBook); // 201
    }
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Book> deleteBookByid(Long id) {
    Book rtnBook = bookService.deleteBookById(id);
    if (rtnBook != null) {
      return ResponseEntity.ok().body(rtnBook); // 200
    }
    return ResponseEntity.noContent().build();
  }

}