package com.vtxlab.demo.bookstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.bookstore.entity.Book;
import com.vtxlab.demo.bookstore.repository.BookRepository;
import com.vtxlab.demo.bookstore.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
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

  @Override
  public Book updateBookById(Book book, Long id) {
    book.setId(id);
    return bookRepository.save(book);
  }

  @Override
  public Book updateBookName(Long id, String bookName) {
    if (bookRepository.existsById(id)) {
      Book book = bookRepository.findById(id).orElse(null);
      book.setBookName(bookName);
      return bookRepository.save(book);
    }
    return null;
  }

  @Override
  public Boolean deleteBooksByAuthorId(Long authorId) {
    Integer bookCount = bookRepository.findBooksByAuthorId(authorId);
    log.info("bookCount={} ", bookCount);
    
    
    if (bookCount > 0) {
      bookRepository.deleteBooksByAuthorId(authorId);
      return true;
    }
    return false;
  }
}
