package com.vtxlab.demo.bookstore.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

  private Long id;

  private String bookName;

  private LocalDate publicDate;

}
