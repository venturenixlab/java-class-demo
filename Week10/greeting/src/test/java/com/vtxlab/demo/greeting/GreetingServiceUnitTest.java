package com.vtxlab.demo.greeting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vtxlab.demo.greeting.entity.Book;
import com.vtxlab.demo.greeting.repository.GreetingRepository;
import com.vtxlab.demo.greeting.service.GreetingService;
import com.vtxlab.demo.greeting.service.impl.GreetingServiceHolder;

@ExtendWith(SpringExtension.class)
class GreetingServiceUnitTest {

  @Mock
  GreetingRepository greetingRepository;

  GreetingService greetingService;

  @BeforeEach
  void init() {
    greetingService = new GreetingServiceHolder(greetingRepository);
  }

  @Test
  void testFindAllBooks() {
    Book book = Book.builder() //
        .bookName("textbook")
        .publicDate(LocalDate.of(2022, 11, 1))
        .build();
    Book book2 = Book.builder() //
        .bookName("textbook 2")
        .publicDate(LocalDate.of(2021, 11, 1))
        .build();
    // Given: Mock repository.findAll, and return a book list
    when(greetingRepository.findAll()).thenReturn(List.of(book, book2));
    // When
    List<Book> books = greetingService.findAllBook();
    // Then
    assertThat(books).hasSize(2);
    
  }
}
