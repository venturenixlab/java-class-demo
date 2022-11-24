package com.vtxlab.demo.bookstore.service;

import java.util.List;

import com.vtxlab.demo.bookstore.model.AuthorDto;

public interface AuthorService {

  List<AuthorDto> findAllAuthors();
  
}
