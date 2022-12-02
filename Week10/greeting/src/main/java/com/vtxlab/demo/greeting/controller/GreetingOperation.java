package com.vtxlab.demo.greeting.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.greeting.entity.Book;

@RequestMapping("/default")
public interface GreetingOperation {

  @GetMapping(value = "/greeting")
  String greeting();

  @GetMapping(value = "/books")
  List<Book> findAllBooks();

  @GetMapping(value = "/book/{id}")
  Book findBookById(@PathVariable("id") Long id);

}
