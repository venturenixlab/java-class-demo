import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Calculator {
  int a, b;

  public static int sum(int a, int b) { // static method
    return a + b;
  }

  // Meaningless to define as instance method
  // static is good enough to substract the numbers from input params
  // The instance variables are not used to determine the result
  public int substract1(int a, int b) {
    return a - b;
  }

  public int substract2(int a, int b) {
    return a - b - this.a - this.b; // 10 - 20 - 3- 1
  }

  public int substract() {
    return this.a - this.b;
  }

  public void setA(int a) {
    this.a = a;
  }

  public void setB(int b) {
    this.b = b;
  }

  public static boolean isLengthLargerThan5(String x) {
    return false;
    // return x.length() > 5;
  }
}

public class DemoStatic {
  public static void main(String[] args) {
    Calculator calculator10 = new Calculator();
    calculator10.setA(3);
    calculator10.setB(1);
    System.out.println(Calculator.sum(10, 20)); // print 30
    System.out.println(calculator10.substract1(10, 20)); // print -10
    System.out.println(calculator10.substract2(10, 20)); // print -14
    System.out.println(calculator10.substract()); // print 2

    Long k = 10l;
    Double d = 100d; // 100 -> int
    Float f = 100f; // 100 -> int

    Double d2 = 9.3; // 100.0 -> double
    Double d3 = 2.4;

    System.out.println("d2/d3= " + d2 / d3);

    BigDecimal b2 = new BigDecimal("9.3");
    BigDecimal b3 = new BigDecimal("2.4");
    System.out.println("d2 * d3= " + b2.multiply(b3).toString());
    System.out.println("d2 / d3= " + b2.divide(b3));

    // int[] integers = new int[10];
    int[] shoppingCartItemPrices = new int[] { 1, 3, 10, 7 }; // 3
    int pool = 100;
    for (int i = 0; i < shoppingCartItemPrices.length; i++) {
      if (shoppingCartItemPrices[i] >= 10) { //
        pool = pool - shoppingCartItemPrices[i];
        // break;
      } else if (shoppingCartItemPrices[i] >= 5) { // 5 - 9
        pool = pool + shoppingCartItemPrices[i];
      } else {
        pool = pool - shoppingCartItemPrices[i];
      }
      // Animal animals = new Cat();
      String string = "10";

      string = null; // developer B

      // System.out.println(string.length()); // NPE

      List<Integer> integers = new ArrayList<>();
      integers.add(1);
      integers.add(2);
      // for (Integer integer : integers) { // loop 2 times
      // integers.add(1);
      // }
    }
    System.out.println(pool);
    // sysout
  }
}
