package com.vtxlab.demo.greeting.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.greeting.controller.GreetingOperation;
import com.vtxlab.demo.greeting.entity.Book;
import com.vtxlab.demo.greeting.service.GreetingService;

import lombok.AllArgsConstructor;

@RestController // During start up, create bean to spring context
// @Component // @Controller or @Service or @Repository or @Configuration
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
public class GreetingController implements GreetingOperation {

  @Autowired
  GreetingService greetingService;

  @Override
  public String greeting() {
    return greetingService.greeting() + "d"; // mock
  }

  @Override
  public List<Book> findAllBooks() {
    return greetingService.findAllBook();
  }

  @Override
  public Book findBookById(Long id) {
    return greetingService.findBookById(id);
  }

}
