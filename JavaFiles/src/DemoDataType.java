// testing git

class Name {
  // attributes
  String firstName;
  String lastName;

  // method - setter
  void setFirstName(String firstname) {
    this.firstName = firstname;
  }

  // method - setter
  void setLastName(String lastName) {
    this.lastName = lastName;
  }

  // method - getter
  String getFirstName() {
    return this.firstName;
  }

  // method - getter
  String getLastName() {
    return this.lastName;
  }

  // Validate if the length of firstName > 10
  // If yes, return false; otherwise return true;
  boolean validateFirstName() {
    if (this.firstName.length() > 10) {
      return false;
    }
    return true;
  }
}

class Animal {

  private int age;
  private int weight;
  // Self-defined Type Name (refer to class Name)
  Name name;

  // Empty Constructor
  // if there is no constructor in this class, empty constructor implicitly exists
  Animal() {
  }

  // if we declare a non-empty constructor, then the implicit empty constructor
  // will be no longer exist
  // we have to declare the empty constructor ourselves
  Animal(int age, int weight, Name name) {
    this.weight = weight;
    this.age = age;
    this.name = name;
  }

  // Method
  void run() {
    System.out.println("I'm running.");
  }

  // Method
  void sound() {
    System.out.println("I'm making a sound.");
  }

  int setAge(int age) {
    return this.age = age;
  }

  int getAge() {
    // other code
    return this.age;
  }

  String getAgeToString() {
    return String.valueOf(30);
  }

  // other setters and getters ...
  public String toString() {
    return "[Age=" + this.age + ", weight=" + this.weight + ", Name.firstName="
        + this.name.getFirstName() + ", Name.lastName="
        + this.name.getLastName() + "]";
  }
}

public class DemoDataType {
  String firstname;

  public static void main(String[] args) {

    // Start to execute
    Animal dog = new Animal(); // by empty constructor
    dog.setAge(8); // set dogAge = 8
    int dogAge = dog.getAge(); // dogAge = 8
    System.out.println("dogAge=" + dogAge);

    Name name = new Name();
    name.setFirstName("Mary");
    name.setLastName("Chan");
    String firstName = name.getFirstName();
    System.out.println("firstName=" + firstName);
    Boolean result = name.validateFirstName();
    System.out.println("result of validateFirstName()=" + result);

    Animal cat = new Animal(3, 3, name); // by non-empty constructor
    System.out.println("cat: " + cat.toString()); // this method is created myself

    Integer x = 10;
    // String str = x.toString();
    String abc = x.toString();
    // String str2 = y;
    System.out.println(abc);

    String x1 = "abc";
    String y1 = "abc";
    System.out.println(x1 == y1); // true
    System.out.println(x1.equals(y1)); // true
    y1 = "bcd";
    x1 = "bcde";
    System.out.println(x1 == y1); // false
    System.out.println(x1.equals(y1)); // false

    Integer x5 = 127;
    Integer y5 = 127;
    // Integer is wrapper class of int,
    // if the value is in range -128 to 127,
    System.out.println(x5 == y5); // true
    System.out.println(x5.equals(y5)); // true
    Integer x6 = 128;
    Integer y6 = 128;
    System.out.println(x6 == y6); // false
    System.out.println(x6.equals(y6)); // true

    // Character char3 = new Character("a");
    String c1 = "c";
    String c2 = "c";
    String c3 = new String("c");
    System.out.println(c1 == c2); // true
    System.out.println(c1 == c3); // false
  }
}
