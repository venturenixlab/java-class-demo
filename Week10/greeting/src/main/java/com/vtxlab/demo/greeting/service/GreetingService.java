package com.vtxlab.demo.greeting.service;

import java.util.List;

import com.vtxlab.demo.greeting.entity.Book;

public interface GreetingService {
  
  String greeting();
  
  List<Book> findAllBook();
}
