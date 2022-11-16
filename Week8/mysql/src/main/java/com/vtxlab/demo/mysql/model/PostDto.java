package com.vtxlab.demo.mysql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
  public Long id;

  public String title;

  public String description;

  public String content;
}
