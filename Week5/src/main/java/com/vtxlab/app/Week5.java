package com.vtxlab.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.vtxlab.model.customer.Customer;
import com.vtxlab.model.customer.SortById;
import com.vtxlab.model.customer.SortByName;
import com.vtxlab.model.product.Product;

public class Week5 {
  public static void main(String[] args) {
    System.out.println("Hello");

    Customer customer = new Customer();
    customer.setName("Vincent");
    System.out.println(customer.toString());

    // Chapter 4 (Week 5)
    Customer customer1 = new Customer(9, "Alex", LocalDate.of(2010, 1, 1));
    Customer customer2 = new Customer(2, "Benny", LocalDate.of(2000, 1, 15));
    Customer customer3 = new Customer(100, "Vincent", LocalDate.of(2022, 9, 15));
    Customer customer4 = new Customer(30, "Tommy", LocalDate.of(2022, 1, 15));
    Customer customer5 = new Customer(100, "Alan", LocalDate.of(2022, 9, 15));
    Customer customer6 = new Customer(100, "Alan", LocalDate.of(2009, 9, 15));

    List<Customer> customers = new ArrayList<>();
    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);
    customers.add(customer4);
    customers.add(customer5);
    customers.add(customer6);

    System.out.println("Comparable:");
    System.out.println("Before Sorting: " + customers);
    // Compilation error, if class Customer do not implement Comparable
    Collections.sort(customers); //
    System.out.println("After Sorting: " + customers);

    // Class implements Comparator
    System.out.println("Comparator:");
    System.out.println("Before Sorting: " + customers);

    int type = 2;
    Collections.sort(customers, getSorting(type));
    System.out.println("After Sorting: " + customers);

    // Lambda
    Comparator<Customer> sortByName = (s1, s2) -> s1.getName().compareTo(s2.getName());
    Comparator<Customer> sortByJoinDate = (s1, s2) -> s1.getJoinDate().compareTo(s2.getJoinDate());
    Comparator<Customer> sortById = (s1, s2) -> Integer.compare(s1.getId(),
        s2.getId());

    Collections.sort(customers,
        sortById.thenComparing(sortByName).thenComparing(sortByJoinDate));
    System.out.println("Customer After Sorting(chain comparing): " + customers);

    Collections.reverse(customers);
    System.out.println("Customer After Sorting(Collections.revise): " + customers);

    // Product list
    Product product1 = new Product(2, "Product 1", "BLUE");
    Product product4 = new Product(6, "Product 4", "YELLOW");
    Product product2 = new Product(5, "Product 2", "PINK");
    Product product3 = new Product(1, "Product 3", "YELLOW");

    List<Product> products = new ArrayList<>();
    products.add(product1);
    products.add(product4);
    products.add(product2);
    products.add(product3);

    Comparator<Product> sortByColor = (p1, p2) -> {
      if ("YELLOW".equals(p2.getColor()) && !"YELLOW".equals(p1.getColor())) {
        return 1; // 1->swap
      } else if ("YELLOW".equals(p2.getColor()) && "YELLOW".equals(p1.getColor())) {
        return 0;
      } else if (!"YELLOW".equals(p2.getColor()) && "YELLOW".equals(p1.getColor())) {
        return -1;
      }
      return p1.getColor().compareTo(p2.getColor()); // ascending
    };
    Collections.sort(products, sortByColor);
    // Collections.sort(products, new SortByColor());

    System.out.println("Product After Sorting: " + products);

  }

  public static Comparator<Customer> getSorting(int type) {
    if (type == 1) {
      return new SortByName();
    }
    return new SortById();
  }
}
