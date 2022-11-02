package com.vtxlab.app;

import java.net.CacheRequest;
import java.util.Optional;

import com.vtxlab.app.enums.Exceptions;
import com.vtxlab.app.exceptions.MobileBackendException;

public class ExceptionTest {

  public static int divide() {
    try {
      return 9 / 0; // runtime unchecked exception, not necessary to handle
    } catch (ArithmeticException e) {
      return 0 / 9;
    }
  }

  public static String getString(Integer... i) {
    return "abc";
  }

  public static void main(String[] args) throws MobileBackendException {
    divide(); // error

    // String s = null;
    // try {
    // int l = s.length();
    // } catch (NullPointerException e) {
    // throw new MobileBackendException(Exceptions.NPE);
    // }
    getString(1, 2, 3);
    // Exceptions.getReturnValue();

    // main
    int x = 2; // x = 2
    int y = calculate(x); // x = 2
    System.out.println(x); // 2
    System.out.println(y); // 3

    StringBuilder o = new StringBuilder("abc");
    calculate(o);
    System.out.println(o.toString());
  }

  // pass by value
  public static int calculate(int x) {
    x = x + 1; // 3
    return x; // 3
  }

  public static Integer calculate(Integer x) {
    x = x + 1;
    return x;
  }

  // pass by reference
  public static void calculate(StringBuilder o) {
    o.append("d");
    // System.out.println(o);
    // return o;
  }

}
