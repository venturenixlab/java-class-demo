interface Starter { // step 8
  void start();
}

// Step 11
interface Stopper {
  void stop();
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
  private String color;
  private int machineCode;

  // Step 8
  @Override
  public void start() {
    System.out.println("[Machine] This is start() method in Starter Contract.");
  }

  // Step 11
  @Override
  public void stop() {
    System.out.println("[Machine] This is stop() method in Starter Contract.");
  }

  Machine() {
    Machine.counter = Machine.counter + 1; // static, Step 6
  }

  Machine(String color, int machineCode) {
    this.color = color;
    this.machineCode = machineCode;
    Machine.counter = Machine.counter + 1; // static, Step 6
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
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
    machine.setColor("RED");
    machine.setMachineCode(123);
    System.out.println(machine.getColor());
    System.out.println(machine.getMachineCode());

    Machine machine2 = new Machine("YELLOW", 456); // counter + 1
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
  }
}
