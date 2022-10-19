interface Driver {
  void drive();
}


interface Cooker {
  void cook();
}

class Mother implements Driver, Cooker {
  int age;

  // Implement Driver and Cooker
  @Override
  public void drive() {
    System.out.println("I'm mother and driving.");
  }

  @Override
  public void cook() {
    System.out.println("I'm mother and cooking.");
  }

  // Mother's method
  public void feed() {
    System.out.println("I'm mother and feeding the children.");
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }
}


interface Machine {
  // No instance variable
  public void start(); // implicitly public

  public void stop(); // implicitly public

  // interface is able to declare a default method with its implemention
  default String sound() {
    return "hunt hunt hunt ...";
  }
}


abstract class Fan implements Machine { // not extends
  String type; // instance variable

  @Override
  public void start() {
    System.out.println("Im a Fan, and I'm starting.");
  }

  @Override
  public void stop() {
    System.out.println("Im a Fan, and I'm stopping.");
  }
  // getSwitch1
}


class SolarPowerFan extends Fan {
  String expiryDate;

  @Override
  public void start() {
    System.out.println("Im a SolarPowerFan, and I'm starting.");
  }
}


public class DemoExtend {
  public static void main(String[] args) {
    // Machine machine = new Machine();
    SolarPowerFan solarPowerFan = new SolarPowerFan();
    solarPowerFan.start();
    solarPowerFan.stop();
    System.out.println(solarPowerFan.sound());

    Mother mother = new Mother();
    mother.setAge(18);
    System.out.println(mother.getAge());
    mother.feed();
    mother.drive();
    mother.cook();
  }

}
