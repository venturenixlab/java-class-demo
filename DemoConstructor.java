import java.util.ArrayList;

class FireFighter {
  private int hoursOfTraining; // arttribute or state
  private int age; // arttribute  or state
  private String sex; // arttribute  or state

  // constructor
  FireFighter() {  
    
  }
  // initialization
  FireFighter(int a, int b, String c) {  
    this.hoursOfTraining = a;
    this.age = b;
    this.sex = c;
  }
  // method or behavior
  public void setHoursOfTraining(int b) {
    this.hoursOfTraining = b;
  }
//  public int getHoursOfTraining() {
//    return this.hoursOfTraining;
//  }

  // method
  Integer addOneToTheInteger(int a) {  // Integer is a return type where int is an input parameter
    return a + 1;
  }

}

class DemoConstructor {

  public static void main(String[] args) {
    List<FireFighter> fireFighters = new ArrayList<>();


    FireFighter fireFighter2 = new FireFighter();
    FireFighter fireFighter4 = new FireFighter(30,15,"F");
    //FireFighter fireFighter = new FireFighter(30); // age
    // FireFighter fireFighter3 = new FireFighter(13, 30); // 
    System.out.print(fireFighter.getHoursOfTraining());
    // fireFighter.addOneToTheInteger(100);
    fireFighter2.setHoursOfTraining(30); // line 33 = 34 ?
    fireFighter2.setHoursOfTraining(31); // line 33 = 34 ?
    fireFighter4.setHoursOfTraining(90);
    // fireFighter.hoursOfTraining = 1; // no problem
  }
}
