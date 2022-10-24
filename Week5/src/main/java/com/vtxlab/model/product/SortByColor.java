package com.vtxlab.model.product;

import java.util.Comparator;

public class SortByColor implements Comparator<Product> {

  @Override
  public int compare(Product p1, Product p2) {
    if ("YELLOW".equals(p2.getColor()) && !"YELLOW".equals(p1.getColor())) {
      return 1; // 1->swap
    } else if ("YELLOW".equals(p2.getColor()) && "YELLOW".equals(p1.getColor())) {
      return 0;
    } else if (!"YELLOW".equals(p2.getColor()) && "YELLOW".equals(p1.getColor())) {
      return -1;
    }
    return p1.getColor().compareTo(p2.getColor()); // ascending
  }

}
