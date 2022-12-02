package com.vtxlab.demo.greeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.greeting.entity.Book;
import com.vtxlab.demo.greeting.repository.GreetingRepository;
import com.vtxlab.demo.greeting.service.GreetingService;

import lombok.AllArgsConstructor;

@Service // During start up, create bean to spring context
@AllArgsConstructor
public class GreetingServiceHolder implements GreetingService {

  @Autowired
  GreetingRepository greetingRepository;

  @Override
  public String greeting() {
    // 99 lines of code ...
    return "abc";
  }

  @Override
  public Book findBookById(Long id) {
    return greetingRepository.findById(id).orElse(new Book());
  }

  @Override
  public List<Book> findAllBook() {
    return greetingRepository.findAll();
  }

}
