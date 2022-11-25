package com.vtxlab.demo.bookstore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.bookstore.entity.Author;
import com.vtxlab.demo.bookstore.model.AuthorDto;

@RequestMapping(value = "/default")
public interface AuthorOperation {

  @GetMapping(value = "/authorss")
  ResponseEntity<List<AuthorDto>> findAllAuthorss();

  @GetMapping(value = "/authors")
  ResponseEntity<List<Author>> findAllAuthors();

  @DeleteMapping(value = "/authors/id/{id}")
  ResponseEntity<Void> deleteById(@PathVariable Long id);
}
