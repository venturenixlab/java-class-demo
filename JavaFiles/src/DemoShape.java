abstract class Shape { // com.apple.app.banner.Shape
  String color; // package-private

  abstract double area();

  void print(String s) {
    System.out.println(s);
  }
}

interface Shape2 {

  double area(); // implicitly public

  // after Java 8
  default void print(String s) {
    System.out.println(s);
  }
}

class Circle2 implements Shape2 {
  int r;

  public double area() {
    return this.r * this.r * 3.14;
  }
}

class Circle extends Shape {
  int r;

  double area() {
    return this.r * this.r * 3.14;
  }
}

public class DemoShape {

}
