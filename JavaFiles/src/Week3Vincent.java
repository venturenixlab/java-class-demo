// step 13 enum
enum Color { // implicity public static final
  RED(1, 'R'), YELLOW(2, 'Y'), BLUE(3, 'B'), GREEN(4, 'G'), WHITE(5, 'W'), BLACK(6, 'L');

  int code;
  char value;

  Color(int code, char value) {
    this.code = code;
    this.value = value;
  }

  public boolean isVipColor() {
    if (this.value == 'L') {
      return true;
    }
    return false;
  }

  public boolean isOlympicColor() {
    if (this.value == 'B' || this.value == 'L'
        || this.value == 'Y' || this.value == 'R'
        || this.value == 'G') {
      return true;
    }
    return false;
  }

  public static Color getColor(int code) {
    for (Color c : Color.values()) {
      if (c.code == code) {
        return c;
      }
    }
    return null;
  }
}

interface Starter { // step 8
  void start();
}

// Step 11
interface Stopper {
  void stop();
}

// Step 12
class Laptop extends Machine {
  static String[] database = new String[10];

  String monitor;
  String keyboard;
  String webCam;

  // this is a method to override the toString() method in Object superClass
  @Override
  public String toString() {
    return "[monitor=" + monitor + "],"
        + "[keyboard=" + keyboard + "],"
        + "[webCam=" + webCam + "]";
  }

  @Override
  public void start() {
    System.out.println("[Laptop] This is start method ...");
  }

  @Override
  public void stop() {
    System.out.println("[Laptop] This is stop method ...");
  }

  void save(String string) {
    boolean isStringStoredInDatabase = false;

    for (int i = 0; i < 10; i++) {
      if (database[i] == null) {
        isStringStoredInDatabase = true;
        database[i] = string;
        break;
      }

    }
    // if database has not enough space to save addition string
    // always replace index 0 of database
    if (!isStringStoredInDatabase) {
      database[0] = string;
    }
  }

  // we can delete the last element of the database only if the element is not
  // null
  void delete() {
    boolean previousIndexHasValue = false;
    for (int i = 0; i < database.length; i++) {
      if (database[i] != null) { // contains value
        previousIndexHasValue = true;
      }
      if (previousIndexHasValue && database[i] == null) { // delete
        // condition
        database[i - 1] = null;
        previousIndexHasValue = false;
      }
      if (previousIndexHasValue && database[i] != null && i == database.length - 1) {
        database[i] = null;
      }
    }
  }

  void delete2() {
    for (int i = 1; i < database.length; i++) {
      if ((database[i - 1] != null && database[i] == null) && (i != database.length)) {
        database[i - 1] = null;
      }
    }
  }
}

// Step 10
class StarterFactory {
  public static Starter createStarter(int type) {
    if (type == 1) {
      return new Phone();
    } else if (type == 2) {
      return new Machine();
    }
    return new Machine();
  }

  public static Starter createStarterByLambda(int type) {
    if (type == 1) {
      return () -> {
        System.out.println("Hello Everyone");
        System.out.println("Goodbye Everyone");
      };
    } else if (type == 2) {
      return () -> System.out.println("[Machine] This is start() method in Starter Contract.");
    }
    return () -> System.out.println("type not found");
  }
}

// Factory Pattern // Step 10
class Phone implements Starter {
  String color;

  @Override
  public void start() {
    System.out.println("[Phone] This is start() method in Starter Contract.");
  }

  // getter and setter ...
}

class Machine implements Starter, Stopper { // step 8 & step 11 implement an interface #12
  public static int counter; // static, Step 6
  private Color color; // step 13 rewrite color from String to enum
  private int machineCode;

  // Step 8
  @Override
  public void start() {
    System.out.println("[Machine] This is start() method in Starter Contract.");
  }

  // Step 11
  @Override
  public void stop() {
    System.out.println("[Machine] This is stop() method in Stopper Contract.");
  }

  Machine() {
    Machine.counter = Machine.counter + 1; // static, Step 6
  }

  Machine(Color color, int machineCode) { // step 13, change constructor param to Color
    this.color = color;
    this.machineCode = machineCode;
    Machine.counter = Machine.counter + 1; // static, Step 6
  }

  public Color getColor() {
    return this.color; // step 13 change return type to enum Color
  }

  public void setColor(Color color) {
    this.color = color; // step 13 change input param type to enum Color
  }

  public int getMachineCode() {
    return this.machineCode;
  }

  public void setMachineCode(int machineCode) {
    this.machineCode = machineCode;
  }

  // step 7 - private static field can be retrived by static method
  public static int getMachineCounter() {
    return Machine.counter;
  }

  // step 7
  public static Machine getEmptyMachine() { // Machine is return type
    return new Machine();
  }

}

public class Week3Vincent {

  public static void main(String[] args) {
    Machine machine = new Machine(); // counter + 1
    machine.setColor(Color.WHITE); // step 13 revise the value to enum Color
    machine.setMachineCode(123);
    System.out.println(machine.getColor());
    System.out.println(machine.getMachineCode());

    Machine machine2 = new Machine(Color.RED, 456); // counter + 1
    System.out.println(machine2.getColor());
    System.out.println(machine2.getMachineCode());

    // Step 6
    System.out.println(Machine.counter); // print no of Machine created
    // step 7
    System.out.println(Machine.getMachineCounter()); // print 2 (no of Machine created)
    // step 7
    Machine machine3 = Machine.getEmptyMachine(); // counter + 1

    // Step 9
    machine3.start();
    // step 10 (Very important)
    Starter starter = new Machine(); // Machine abc = new Machine(); (Same thing)
    starter.start();
    // starter.getColor(); // compile error, because Starter doesn't have getColor()
    // method
    // Lambda Expression. Class Machine is no longer required.
    Starter starter2 = () -> {
      System.out.println("Hello Everyone");
      System.out.println("Goodbye Everyone");
    };
    starter2.start();

    // Step 10 Factory Pattern
    Starter starterHolder = StarterFactory.createStarter(1); // 1 or 2
    starterHolder.start();
    Starter starterHolder2 = StarterFactory.createStarterByLambda(2); // 1 or 2
    starterHolder2.start();
    // starterHolder.stop(); // Compile error, we need a StopperFactory

    // Step 12
    Laptop laptop = new Laptop();
    laptop.setColor(Color.GREEN); // step 13 revise the value to enum Color
    laptop.setMachineCode(789);
    System.out.println(laptop.getColor());
    System.out.println(laptop.getMachineCode());

    laptop.start();
    System.out.println(laptop.toString()); // nothing to print

    laptop.save("1");
    laptop.save("2");
    laptop.save("3");
    laptop.save("4");
    laptop.save("5");
    laptop.save("6");
    laptop.save("7");
    laptop.save("8");
    laptop.save("9");
    laptop.save("10");
    laptop.save("11");
    laptop.delete();
    laptop.delete();

    for (String string : Laptop.database) {
      System.out.println(string);
    }
    // Step 13 call the enum method
    if (Color.BLACK.isVipColor()) {
      System.out.println("Black is a vip color");
    }
    if (Color.RED.isOlympicColor()) {
      System.out.println("Red is a Olympic color");
    }

  }
}
