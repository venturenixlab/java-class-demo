package com.vtxlab.app.lambda;

public class FuncInterfaceTest {

  public static void main(String[] args) {
    Cow cow = (a) -> {
      // check if a is number string
      if (isNumeric(a)) {
        return Integer.valueOf(a);
      }
      return 0;
    };
    System.out.println(cow.drink("abc"));
    System.out.println(cow.drink("12"));
  }

  public static boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

}
