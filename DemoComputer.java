
class Computer {
  private int number;
  private String name;

  private Computer(Builder builder) {
    this.number = builder.number;
    this.name = builder.name;
  }

  private Computer() {
  }

  public void setNumber(int newNumber) {
    this.number = newNumber;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public int getNumber() {
    return this.number;
  }

  public String getName() {
    return this.name;
  }

  public void printStatus() {
    System.out.println("Status:\n\tname:" + this.name + "\n\tnumber: " + this.number + "\n============");
  }

  public Builder builder() {
    return new Builder();
  }

  // builder class
  public static class Builder {
    private int number;
    private String name;

    public void assignNumber(int value) {
      this.number = value;
      // return this;
    }

    public void assignName(String value) {
      this.name = value;
      // return this;
    }

    public Computer build() {
      return new Computer(this);
    }
  }
}

public class DemoComputer {
  public static void main(String[] arg) {
    Computer.Builder myComp = new Computer.Builder();
    myComp.assignNumber(23);
    myComp.assignName("Karson");
    Computer computer = myComp.build();

    computer.printStatus();

    // computer.printStatus();

    // myComp.printStatus();

  }
}