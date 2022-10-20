package com.vtxlab.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vtxlab.infra.Foundation;
import com.vtxlab.model.Customer;

public class Helloworld {

  public static void main(String[] args) { // main
    System.out.println("I am Vincent. Hello."); // sysout
    // com.vtxlab.model.Customer
    Customer customer = new Customer();
    customer.setName("Vincent");
    System.out.println(customer.getName());

    // Lambda
    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer());
    customers.add(new Customer());

    for (Customer c : customers) {
      System.out.println(c.getName()); // loop 2 times
    }
    // forEach method by lambda
    customers.forEach(abc -> System.out.println(abc.getName()));

    String s = "abc";
    System.out.println(s.concat("bcd"));

    StringBuilder sb = new StringBuilder("start ");
    // sb = sb.append("class");
    System.out.println(sb.append("class").toString());

    Foundation.println("Testing Self-build Java Library");
    Foundation.print(s);

  }
}