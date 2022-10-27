package com.vtxlab.app;

import java.util.Arrays;

public class Box<T> {
  // T stands for "Type", naming convention only.
  // You can use other Character, such as S.
  private T t;

  public void set(T t) {
    this.t = t;
  }

  public T get() {
    return t;
  }

  public static void main(String[] args) {

    Box<Integer> integerBox = new Box<>();
    integerBox.set(1);
    System.out.println(integerBox.get()); // prints 1

    Box<Object> stringBox = new Box<>();
    stringBox.set("123");
    System.out.println(stringBox.get()); // prints "hello"

    Box<int[]> intArrayBox = new Box<>();
    intArrayBox.set(new int[] { 1, 2, 3 });
    System.out.println(Arrays.toString(intArrayBox.get())); // prints [1,2,3]
  }
}
