import java.util.ArrayList;
import java.util.List;

class Height {
  private double height; // cm

  // Constructor
  Height(double height) {
    this.height = height;
  }

  Height() {

  }

  public double getHeightInCm() {
    return this.height;
  }

  public void setHeightInCm(double height) {
    this.height = height;
  }

  public double getHeightInMetres() {
    return this.height / 100;
  }
}

class Building {
  // attributes
  // Define the attribute "height" by the Type Height,
  // instead of int or String or double, etc
  private Height height;

  // constructors
  Building(Height height) {
    this.height = height;
  }

  Building() {

  }

  // methods
  public Height getHeight() {
    return this.height;
  }

  public void setHeight(Height height) {
    this.height = height;
  }
}

class ShoppingMall extends Building {
  private final Conceirge conceirge; // final

  // Demostrate how to deal with final attribute with constructors
  ShoppingMall() {
    this.conceirge = new Conceirge();
  }

  // or you can compare this normal constructor
  ShoppingMall(Conceirge conceirge) {
    this.conceirge = conceirge;
  }

  public Conceirge getConceirge() {
    return this.conceirge;
  }
}

class Conceirge {
  private final ArrayList<Receptionist> receptionists = new ArrayList<>();

  // A Constructor that assign the fixed receptionists directly
  Conceirge() {
    this.receptionists.add(new Receptionist("Alan", "Ho", "123"));
    this.receptionists.add(new Receptionist("Sunny", "Ng", "234"));
    this.receptionists.add(new Receptionist("Amir", "Yu", "1234"));
  }

  // Another Constructor that assign receptionists by main method
  Conceirge(ArrayList<Receptionist> receptionists) {
    for (Receptionist r : receptionists) {
      this.receptionists.add(r);
    }
  }

  public ArrayList<Receptionist> getReceptionists() {
    return this.receptionists;
  }
}

class Receptionist {
  private final String firstName;
  private final String lastName;
  private final String staffNo;

  Receptionist(String firstName, String lastName, String staffNo) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.staffNo = staffNo;
  }

  public String getFirstName() {
    return this.firstName;
  }
}

public class DemoBuilding {
  public static void main(String[] args) {
    // Create building Object
    Building building = new Building();
    Building building2 = new Building(new Height(14.5)); //
    // create height object
    Height height = new Height(); // empty constructor in Class Height
    // set height to the object in cm
    height.setHeightInCm(13.0);
    //
    building.setHeight(height);

    System.out.println(building.getHeight().getHeightInCm()); // print 13
    System.out.println(building.getHeight().getHeightInMetres()); // print 0.13
    System.out.println(building2.getHeight().getHeightInCm()); // print 14.5

    // Example 1 for ShoppingMall:
    // This constructor actually creates Conceirge and fixed Receptionist
    ShoppingMall shoppingMall = new ShoppingMall();

    for (Receptionist r : shoppingMall.getConceirge().getReceptionists()) {
      System.out.println(r.getFirstName()); // print all Receptionist with firstName
    }

    // Example 2 for ShoppingMall:
    ArrayList<Receptionist> receptionists = new ArrayList<>();
    receptionists.add(new Receptionist("Cherry", "Wong", "234"));
    receptionists.add(new Receptionist("Sue", "Yu", "789"));

    ShoppingMall shoppingMall2 = new ShoppingMall(new Conceirge(receptionists));
    for (Receptionist r : shoppingMall2.getConceirge().getReceptionists()) {
      System.out.println(r.getFirstName()); // print all Receptionist with firstName
    }
  }
}
