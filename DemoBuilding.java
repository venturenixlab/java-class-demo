import java.util.ArrayList;

class Height {
  private double height; // cm

  // int heightInMetres;

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
  private Height height; // cm
  // private Password password;
  // constructor

  Building(Height height) {
    this.height = height;
  }

  Building() {

  }
  // method

  public Height getHeight() {
    return this.height;
  }

  public void setHeight(Height height) {
    this.height = height;
  }
}

class ShoppingMall extends Building {
  private final Conceirge conceirge;

  ShoppingMall() {
    this.conceirge = new Conceirge();
  }

  public Conceirge getConceirge() {
    return this.conceirge;
  }
}

class Conceirge {
  private final ArrayList<Receptionist> receptionists = new ArrayList<>();

  Conceirge() {
    this.receptionists.add(new Receptionist("Alan", "Ho", "123"));
    this.receptionists.add(new Receptionist("Sunny", "Ng", "234"));
    this.receptionists.add(new Receptionist("Amir", "Yu", "1234"));
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

    ShoppingMall shoppingMall = new ShoppingMall(); // 3 or 4 or 10

    for (Receptionist r : shoppingMall.getConceirge().getReceptionists()) {
      System.out.println(r.getFirstName());
    }
  }
}
