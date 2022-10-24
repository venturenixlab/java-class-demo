package com.vtxlab.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Product implements Comparable<Product> {

  private int productId;

  // private LocalDate productionDate;

  private String productName;

  private String color;

  @Override
  public int compareTo(Product p) {
    return p.getProductName().compareTo(this.getProductName());
  }

}
