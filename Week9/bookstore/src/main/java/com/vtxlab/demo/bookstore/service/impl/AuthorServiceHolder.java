package com.vtxlab.demo.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.bookstore.entity.Author;
import com.vtxlab.demo.bookstore.repository.AuthorRepository;
import com.vtxlab.demo.bookstore.service.AuthorService;

@Service
public class AuthorServiceHolder implements AuthorService {

  @Autowired
  AuthorRepository authorRepository;

  private Boolean existById(Long id) {
    return authorRepository.existsById(id);
  }

  @Override
  public void deleteAuthor(Long id) {
    if (existById(id)) {
      authorRepository.deleteById(id);
    }
    return;
  }

  @Override
  public List<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

}
