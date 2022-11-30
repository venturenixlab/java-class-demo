package com.vtxlab.demo.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vtxlab.demo.bookstore.controller.impl.BookController;
import com.vtxlab.demo.bookstore.repository.BookRepository;
import com.vtxlab.demo.bookstore.service.BookService;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	BookController bookController;

	@Autowired
	BookService bookService;
	
	@Autowired
	BookRepository bookRepository;

	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull();
		assertThat(bookService).isNotNull();
		assertThat(bookRepository).isNotNull();
	}

}
