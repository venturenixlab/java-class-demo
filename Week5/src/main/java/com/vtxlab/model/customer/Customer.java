package com.vtxlab.model.customer;

import java.time.LocalDate;
import java.util.Comparator;

import javax.script.Compilable;

import com.vtxlab.model.product.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Annotations
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Comparable<Customer> {

  private int id;

  private String name;

  private LocalDate joinDate;

  @Override
  public int compareTo(Customer c) {
    // return Integer.compare(this.id, c.getId()); // ascending order
    return Integer.compare(c.getId(), this.id); // descending order
    // return c.getName().compareTo(this.name); // descending order
    // return this.name.compareTo(c.getName()); // descending order
  }
}
