package com.vtxlab.demo.bookstore.service;

import java.util.List;

import com.vtxlab.demo.bookstore.entity.Author;

public interface AuthorService {

  List<Author> findAllAuthors();

  void deleteAuthor(Long id);
}
