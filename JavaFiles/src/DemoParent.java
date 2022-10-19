class Animal {
  private int age; // private attribute cannot be inherited

  Animal() {

  }

  Animal(int age) {
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}

// class signature
class Cat extends Animal {

  Cat() {

  }

  Cat(int age) {
    super(age);
  }
}

public class DemoParent {
  public static void main(String[] args) {

    Cat cat = new Cat();
    Cat cat2 = new Cat(3);
    System.out.println(cat.getAge());
    System.out.println(cat2.getAge());
  }
}
