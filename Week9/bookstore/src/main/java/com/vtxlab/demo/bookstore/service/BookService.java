package com.vtxlab.demo.bookstore.service;

import java.util.List;
import java.util.Optional;

import com.vtxlab.demo.bookstore.entity.Book;

public interface BookService {

  List<Book> findAllBooks();

  Optional<Book> findBookById(Long id);

  Book createBook(Book book);

  Book deleteBookById(Long id);

  Book updateBookById(Book book, Long id);

  Book updateBookName(Long id, String bookName);
}
