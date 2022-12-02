package com.vtxlab.demo.bookstore;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.vtxlab.demo.bookstore.controller.impl.AuthorController;
import com.vtxlab.demo.bookstore.entity.Author;
import com.vtxlab.demo.bookstore.entity.Book;
import com.vtxlab.demo.bookstore.service.BookService;

@WebMvcTest // spring context with controller bean
class BookstoreControllerIntegrationTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	BookService bookService;

	// Springboot bug?
	@MockBean
	AuthorController authorController;

	@Test
	void testBookService() throws Exception {
		// Given
		Book book = new Book(11l, "Tommy Book", LocalDate.of(2022, 1, 21),
				new Author());
		Book book2 = new Book(12l, "Steve Book", LocalDate.of(2021, 10, 21),
				new Author());
		when(bookService.findAllBooks()).thenReturn(List.of(book, book2));
		// When
		mockMvc.perform(get("/api/v1/books"))
				.andDo(print()) // print the whole response detail
				.andExpect(status().isOk()) // Check if status = 200
				.andExpect(jsonPath("$.length()").value(2))
				.andExpect(jsonPath("$[0].bookName").value("Tommy Book"))
				.andReturn();

		// String str = result.getResponse().getContentAsString();
		// ApiResponse response = objectMapper.readValue(str, ApiResponse.class);
		// List<Book> books = (List<Book>) response.getData();
		// assertThat(books).hasSize(2);
		mockMvc.perform(get("/api/v1/book1"))
				.andDo(print())
				.andExpect(status().isNotFound()); // 404

		mockMvc.perform(get("/api/v1/book")) // POST METHOD URI
				.andDo(print())
				.andExpect(status().isMethodNotAllowed()); // Should use POST
	}

}
