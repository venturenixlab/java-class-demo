package com.vtxlab.demo.bookstore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.bookstore.entity.Book;

@RequestMapping(value = "/default")
public interface BookOperation {

    @GetMapping(value = "/books")
    List<Book> findAllBooks();

    @GetMapping(value = "/book/id/{id}")
    ResponseEntity<Book> findBookById(@PathVariable Long id);

    @PostMapping(value = "/book")
    ResponseEntity<Book> createBook(@RequestBody Book book);

    @DeleteMapping(value = "/book/id/{id}")
    ResponseEntity<Book> deleteBookByid(@PathVariable Long id);

    @PutMapping(value = "/book/id/{id}")
    ResponseEntity<Book> updateBook(@RequestBody Book book,
            @PathVariable Long id);

    @PatchMapping(value = "/book/id/{id}/name/{bookName}")
    ResponseEntity<Book> updateBookName(@PathVariable Long id,
            @PathVariable String bookName);

    @DeleteMapping(value = "/book/author/id/{id}")
    ResponseEntity<Boolean> deleteBookByAuthorId(@PathVariable Long id);
}
