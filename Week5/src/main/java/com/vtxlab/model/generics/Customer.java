package com.vtxlab.model.generics;

public class Customer<T> {

  private T age;

  public T getAge() {
    return this.age;
  }

  public void setAge(T age) {
    this.age = age;
  }

  public static <T> T calcAge(T a) {
    return a;
  }

  public static <T extends Number> T calcAge2(Customer<T> a) {
    return a.getAge();
  }

  public static Customer<? extends Number> calcAge3(Customer<? extends Number> a) {
    return new Customer<Integer>();
  }

}
