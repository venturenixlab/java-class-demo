package com.vtxlab.app;

import java.util.Collections;

import com.vtxlab.model.generics.Circle;
import com.vtxlab.model.generics.Customer;
import com.vtxlab.model.generics.IntegerHolder;
import com.vtxlab.model.generics.Shape;

public class Generics {
  public static void main(String[] args) {

    IntegerHolder intHolder = new IntegerHolder();
    intHolder.setI(101);
    System.out.println(intHolder.getI());

    Customer customer = new Customer<>();
    customer.setAge("123");
    // System.out.println(customer.getAge().equals(customer));
    String s = (String) customer.getAge(); // runtime error (may be)
    System.out.println(s);

    Customer<Integer> customer2 = new Customer<>();
    customer2.setAge(12);
    System.out.println(customer2.getAge());

    Customer<Double> customer3 = new Customer<>();
    // customer3.setAge(12); // error
    customer3.setAge(12.0);
    customer3.setAge(12d); // 12d means 12 in double
    System.out.println(customer3.getAge());

    Customer<Float> customer4 = new Customer<>();
    // customer4.setAge(12); // error
    customer4.setAge(12.0f); // Java compiler default 12.0 as a double
    customer4.setAge(12f); // 12f means 12 in float
    System.out.println(customer4.getAge());
    System.out.println(Customer.calcAge(Integer.valueOf(4))); // 4
    System.out.println(Customer.calcAge(123)); // 4

    Circle circle = new Circle();
    circle.setRadius(3);
    System.out.println(circle.area()); // 28.26
    // Circle circle = new Circle();

    System.out.println("Circle Area:" + Shape.calcArea(new Circle(3)));

    Shape.calcArea(new Circle(3));
    Shape.calcArea(new Circle(3));
    Shape.calcArea(new Circle(3));

  }
}
