package com.vtxlab.app;

import com.vtxlab.app.enums.Exceptions;
import com.vtxlab.app.exceptions.MobileBackendException;

public class ExceptionTest {

  public static int divide() {
    try {
      return 9 / 0; // error
    } catch (ArithmeticException e) {
      return 0 / 9;
    }

  }

  public static void main(String[] args) throws MobileBackendException {
    divide(); // error

    String s = null;
    try {
      int l = s.length();
    } catch (NullPointerException e) {
      throw new MobileBackendException(Exceptions.NPE);
    }
  }
}
