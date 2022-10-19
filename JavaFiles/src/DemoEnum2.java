class Customer {

  private String name;
  private int age;
  private String email;

  Customer() {
  };

  // setters
  Customer(String name, int age, String email) {
    this.name = name;
    this.age = age;
    this.email = email;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public boolean isElderly() {
    return this.age > 60;
  }

  public boolean isValidEmail() {
    return this.email.length() < 100;

  }
}

enum Direction { // implicitly public static final
  NORTH('N', -1), EAST('E', 2), SOUTH('S', 1), WEST('W', -2);

  char dbValue;
  int code;

  private Direction(char dbValue, int code) {
    this.dbValue = dbValue;
    this.code = code;
  }

  // System.out.println(Direction.NORTH.isOppsite(Direction.EAST)); // false
  public boolean isOppsite(Direction d) {
    boolean result = d.code * -1 == this.code;
    return result;
  }

  public int getCode() {
    return this.code;
  }

  public static Direction valueOf(char c) {
    for (Direction d : Direction.values()) { // Direction.values() means Direction Set
      if (d.dbValue == c) {
        return d;
      }
    }
    return null; // or throw exception
  }

  public static Direction valueOf(int code) {
    for (Direction d : Direction.values()) {
      if (d.code == code) {
        return d;
      }
    }
    return null; // or throw exception
  }

}

enum WeekDay { // implicitly public static final
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
}

enum Status { // implicitly public static final
  ORDERED(1), PAID(2), SHIPPED(3), COMPLETED(4);

  private int code;

  private Status(int code) {
    this.code = code;
  }

  public boolean isForwardStatus(Status s) {
    return s.code > this.code;
  }

  public static boolean isForwardStatus(Status oldStatus, Status newStatus) {
    return newStatus.code > oldStatus.code; // return data type true or false
  }

  public static boolean isBackwardStatus(Status oldStatus, Status newStatus) {
    return newStatus.code < oldStatus.code; // return data type true or false
  }
}

class DemoEnum2 {
  public static void main(String[] args) {
    Customer customer = new Customer("Tom", 12, "Tom123@gmail.com");

    if (customer.isValidEmail()) {
      System.out.println("checked it's valid email");
    }

    if (customer.isElderly()) {
      System.out.println("checked it's elderly");
    }
    System.out.println(Direction.EAST); // print EAST

    Direction north = Direction.NORTH;
    System.out.println(north.dbValue); // print N
    System.out.println(Direction.WEST.dbValue); // print W

    Direction input = Direction.SOUTH;
    System.out.println(Direction.valueOf('N')); // print NORTH
    System.out.println(Direction.valueOf(2)); // print EAST
    System.out.println(Direction.NORTH.isOppsite(Direction.EAST)); // false
    System.out.println(Status.ORDERED.isForwardStatus(Status.PAID)); // true

    System.out.println(Direction.NORTH); // print NORTH
    System.out.println(Direction.NORTH.name()); // print NORTH
    System.out.println(Direction.EAST.ordinal()); // print 2
    System.out.println(Direction.valueOf('N')); // print NORTH

    if (Status.isForwardStatus(Status.ORDERED, Status.PAID)) {
      System.out.println("Okay to update");
    }

    if (Status.ORDERED.isForwardStatus(Status.COMPLETED)) {
      System.out.println("Okay to update");
    }

  }
}