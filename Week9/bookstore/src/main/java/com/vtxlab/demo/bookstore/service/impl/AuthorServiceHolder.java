package com.vtxlab.demo.bookstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.bookstore.model.AuthorDto;
import com.vtxlab.demo.bookstore.model.BookDto;
import com.vtxlab.demo.bookstore.repository.AuthorRepository;
import com.vtxlab.demo.bookstore.service.AuthorService;

@Service
public class AuthorServiceHolder implements AuthorService {

  @Autowired
  AuthorRepository authorRepository;

  @Autowired
  ModelMapper modelmapper;

  @Override
  public List<AuthorDto> findAllAuthors() {
    return authorRepository.findAll().stream().map(e -> {
      List<BookDto> books = e.getBooks().stream() //
          .map(b -> modelmapper.map(b, BookDto.class)) //
          .collect(Collectors.toList());

      return new AuthorDto(e.getId(), e.getAuthorName(),
          e.getNationality(), books);
    }).collect(Collectors.toList());
  }
}
