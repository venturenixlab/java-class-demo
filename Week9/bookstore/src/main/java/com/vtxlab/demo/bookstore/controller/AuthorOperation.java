package com.vtxlab.demo.bookstore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.bookstore.model.AuthorDto;

@RequestMapping(value = "/default")
public interface AuthorOperation {

  @GetMapping(value = "/authors")
  ResponseEntity<List<AuthorDto>> findAllAuthors();

}
