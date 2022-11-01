package com.vtxlab.app;

public class IllegalStateExceptions {

  public static void print(int a, int b) {
    System.out.println("Addition of Positive Integers :" + (a + b));
  }

  public static void printAddition(int x, int y) {
    // Objects.requireNonNull(x);
    // example: x & y, get other value from database
    if (x >= 0 && y >= 0) {
      IllegalStateExceptions.print(x, y);
      // store into database
    } else {
      throw new IllegalStateException("Either one or two numbers are not Positive Integer");
    }
  }

  public static void main(String[] args) {
    try {
      printAddition(-1, -100); // caller
      // hit ISE
      int d = 1;
    } catch (IllegalStateException e) {
      printAddition(1, 1); // aligned with user
    }

    // Object i = 10;
    // String s = (String) i; // java.lang.ClassCastException
    try {
      int c = divide(10, 0);
    } catch (CustomException e) {
      System.out.println("I do nothing");
    } catch (Exception e1) {
      System.out.println("default Exception");
    }
  }

  public static int divide(int a, int b) {
    try {
      return a / b;
    } catch (ArithmeticException e) {
      throw new CustomException("hello");
    }
    
  }
}
