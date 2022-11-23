package com.vtxlab.demo.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtxlab.demo.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findByAuthorName(String authorName);

  List<Book> findByAuthorNameAndBookName(String authorName, String bookName);

  
}
