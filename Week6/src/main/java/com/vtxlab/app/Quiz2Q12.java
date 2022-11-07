import java.util.Deque;
import java.util.LinkedList;

class Car {
  int speed = 100;
  static Car instance = new Car();

  private Car() {
  }

  public static Car getInstance() {
    return instance;
  }

  // instance method
  public void setSpeed(int s) {
    this.speed = s;
  }
}

public class Quiz2Q12 {
  public static void main(String[] args) {
    Deque<Car> deque = new LinkedList<>();

    Car tesla = Car.getInstance();
    Car toyota = Car.getInstance();

    tesla.setSpeed(80); // set tesla speed to 80

    deque.add(tesla); // Tail, Last
    deque.push(toyota); // Head, First

    System.out.println(deque.getLast().speed + " " + deque.getFirst().speed);
  }
}
