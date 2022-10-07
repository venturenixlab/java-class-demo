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
  }
}
