package com.vtxlab.demo.bookstore.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.bookstore.controller.AuthorOperation;
import com.vtxlab.demo.bookstore.entity.Author;
import com.vtxlab.demo.bookstore.model.AuthorDto;
import com.vtxlab.demo.bookstore.service.AuthorService;

@RestController
@RequestMapping(value = "/api/v1")
public class AuthorController implements AuthorOperation {

  @Autowired
  AuthorService authorService;

  @Override
  public ResponseEntity<List<AuthorDto>> findAllAuthors() {
    List<AuthorDto> authors = authorService.findAllAuthors();
    return ResponseEntity.ok().body(authors);
  }
}
