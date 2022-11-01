package com.vtxlab.app;

public class Exceptions {
  public static void main(String[] args) {
    int i = 0;
    int y = 2;

    try {
      y = y / i; // java.lang.ArithmeticException: / by zero
      // ...
      // ...
    } catch (ArithmeticException e) {
      y = 0;
    }

    System.out.println(y);
  }
}
