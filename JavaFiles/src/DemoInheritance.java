final class Utility {
    // No attributes
    public int age;

    public static void someStaticMethod() {
        System.out.println("[Animal] Some static method from Animal...");
    }

    public static int addSomething(int x, int y) {
        return x + y;
    }
}

abstract class Animal {
    protected String name;
    protected int weight;
    protected int height;
    public String someProperty; // for testing

    public Animal(String name, int weight, int height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.someProperty = "[Animal] someProperty from Animal...";
    }

    // abstract method must be implemented by subclasses
    public abstract void makeSound();

    // default method is overridden optionally by subclasses
    public void sleep() {
        System.out.println("[Animal] Zzzzzzzzzzzzzzzz");
    }

    // final method cannot be overridden by subclasses
    public final void doNothing() {
        System.out.println("[Animal] doNothing");
    }

    public static void someStaticMethod() {
        System.out.println("[Animal] Some static method from Animal...");
    }

    // getters and setters for the remaining fields
}

class Cat extends Animal {
    public String someProperty; // testing

    public Cat(String name, int weight, int height) {
        super(name, weight, height);
        this.someProperty = "[Cat] someProperty ...";
    }

    @Override
    public void makeSound() {
        System.out.println("[Cat] Meowwwwwwww");
    }

    @Override
    public void sleep() {
        System.out.println("[Cat] Meowwwwwwww... Zzzzzzzzzzzzz");
    }

    public String getSomeProperty() {
        return someProperty;
    }

    // @Override
    // public void doNothing() {
    // // Compilation error -- final methods cannot be overridden by subclasses
    // }
}

class Dog extends Animal {
    public Dog(String name, int weight, int height) {
        super(name, weight, height);
    }

    @Override
    public void makeSound() {
        System.out.println("[Dog] Woof Woof !!");
    }

    @Override
    public void sleep() {
        System.out.println("[Dog] Woof woof... Zzzzzzzzzzzzz");
    }

    // Static method with the same name as superclass --> thus hiding superclass
    // method
    public static void someStaticMethod() {
        System.out.println("[Dog] Some static method from Dog...");
    }
}

public class DemoInheritance {
    public static void main(String[] args) {
        // Animal animal = new Animal(); // Compilation error

        Cat cat = new Cat("Garfield", 10, 10);
        Dog dog = new Dog("Goofy", 30, 30);

        cat.makeSound();
        cat.sleep();

        dog.makeSound();
        dog.sleep();

        System.out.println("someProperty : " + cat.someProperty);
        System.out.println("getSomeProperty : " + cat.getSomeProperty());

        Animal.someStaticMethod();
        // dog.someStaticMethod();

        Utility.someStaticMethod();
        System.out.println(Utility.addSomething(100, 200));
    }
}

/*
 * Output:
 * [Cat] Meowwwwwwww
 * [Cat] Meowwwwwwww... Zzzzzzzzzzzzz
 * [Dog] Woof Woof !!
 * [Dog] Woof woof... Zzzzzzzzzzzzz
 * someProperty : [Cat] someProperty ...
 * getSomeProperty : [Cat] someProperty ...
 * 
 */
