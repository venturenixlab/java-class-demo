package com.vtxlab.demo.greeting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.greeting.entity.Book;
import com.vtxlab.demo.greeting.repository.GreetingRepository;
import com.vtxlab.demo.greeting.service.GreetingService;

@Service // During start up, create bean to spring context
public class GreetingServiceHolder implements GreetingService {

  @Autowired
  GreetingRepository greetingRepository;

  @Override
  public String greeting() {
    return "abc";
  }

  @Override
  public List<Book> findAllBook() {
    return greetingRepository.findAll();
  }

}
