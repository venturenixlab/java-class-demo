class Animal {

}

class Cat extends Animal {
  int age;

  public int getAge() {
    return this.age;
  }
}

class Dog extends Animal {

}

public class DemoCasting {
  public static void main(String[] args) {
    Animal animal = new Cat(); // upcasting
    Animal animal2 = new Animal();
    Animal animal3 = new Dog(); // upcasting

    if (animal instanceof Cat) {
      Cat cat = (Cat) animal; // downcasting
      System.out.println("animal is an instance of Cat, age=" + cat.getAge());
    } else {
      System.out.println("animal is not instance of Cat");
    }

    if (animal2 instanceof Cat) {
      Cat cat = (Cat) animal2; // downcasting
      System.out.println("animal2 is an instance of Cat, age=" + cat.getAge());
    } else {
      System.out.println("animal2 is not instance of Cat");
    }

    if (animal3 instanceof Cat) {
      Cat cat = (Cat) animal3; // downcasting
      System.out.println("animal3 is an instance of Cat, age=" + cat.getAge());
    } else {
      System.out.println("animal3 is not instance of Cat");
    }

    // Cast Primitive
    int b = 130;
    byte i = (byte) b; // casting
    System.out.println(i);
  }
}
