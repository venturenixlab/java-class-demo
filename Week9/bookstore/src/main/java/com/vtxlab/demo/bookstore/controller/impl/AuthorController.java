package com.vtxlab.demo.bookstore.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.sym.Name;
import com.vtxlab.demo.bookstore.controller.AuthorOperation;
import com.vtxlab.demo.bookstore.entity.Author;
import com.vtxlab.demo.bookstore.model.AuthorDto;
import com.vtxlab.demo.bookstore.model.BookDto;
import com.vtxlab.demo.bookstore.service.AuthorService;


@RestController
@RequestMapping(value = "/api/v1")
public class AuthorController implements AuthorOperation {

  @Autowired
  // @Qualifier(value = "beanName")
  AuthorService authorService;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public ResponseEntity<List<AuthorDto>> findAllAuthorss() {
    List<AuthorDto> authorDtos = authorService.findAllAuthors()
        .stream() //
        .map(e -> {
          List<BookDto> books = e.getBooks().stream() //
              .map(b -> modelMapper.map(b, BookDto.class)) //
              .collect(Collectors.toList());

          return new AuthorDto(e.getId(), e.getAuthorName(),
              e.getNationality(), books);
        }).collect(Collectors.toList());

    return ResponseEntity.ok().body(authorDtos);
  }

  @Override
  public ResponseEntity<List<Author>> findAllAuthors() {
    List<Author> authors = authorService.findAllAuthors();
    return ResponseEntity.ok().body(authors);
  }

  @Override
  public ResponseEntity<Void> deleteById(Long id) {
    authorService.deleteAuthor(id);
    return ResponseEntity.ok().build();
  }
}
