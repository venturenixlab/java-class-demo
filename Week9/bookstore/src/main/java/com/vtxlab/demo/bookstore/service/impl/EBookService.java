package com.vtxlab.demo.bookstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.bookstore.entity.Book;
import com.vtxlab.demo.bookstore.repository.BookRepository;
import com.vtxlab.demo.bookstore.service.BookService;

@Service
public class EBookService implements BookService {

  @Autowired
  BookRepository bookRepository;

  @Override
  public List<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public Optional<Book> findBookById(Long id) {
    return bookRepository.findById(id);
  }

  @Override
  public Book createBook(Book book) {
    if (!bookRepository.existsById(book.getId())) {
      return bookRepository.save(book);
    }
    return null;
  }

  @Override
  public Book deleteBookById(Long id) {
    if (bookRepository.existsById(id)) {
      Book book = findBookById(id).orElse(null);
      bookRepository.deleteById(id);
      return book;
    }
    return null;
  }
}
