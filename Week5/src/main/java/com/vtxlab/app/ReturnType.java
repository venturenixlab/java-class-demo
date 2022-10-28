package com.vtxlab.app;

public class ReturnType {

  public static void print123() { // void, no return type
    System.out.println("123"); // print
    int a = 1;
  }

  public static int print(int x) {
    return x; // throw
  }

  public static void printx(int x) {
    System.out.println(x); // printx, execute the function of line 15 only
  }

  public static void main(String[] args) {
    // System.out.print(void.class);
    System.out.println(print(10));
    ReturnType boy = new ReturnType();
  }
}
