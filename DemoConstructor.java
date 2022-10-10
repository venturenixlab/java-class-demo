import java.util.ArrayList;
import java.util.List;

class FireFighter {
  private int hoursOfTraining; // arttribute or state
  private int age; // arttribute or state
  private String sex; // arttribute or state

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

  public int getHoursOfTraining() {
    return this.hoursOfTraining;
  }

  // method
  public Integer AddTrainingHour(int a) { // Integer is a return type and int is an input parameter
    return this.hoursOfTraining + a;
  }
}

class DemoConstructor {

  public static void main(String[] args) {
    List<FireFighter> fireFighters = new ArrayList<>();
    FireFighter fireFighter1 = new FireFighter();
    FireFighter fireFighter2 = new FireFighter(30, 15, "F");
    System.out.print(fireFighter2.getHoursOfTraining());
    fireFighter1.setHoursOfTraining(40);
    fireFighter2.setHoursOfTraining(90);
    fireFighter1.AddTrainingHour(3);
    fireFighters.add(fireFighter1);
    fireFighters.add(fireFighter2);
  }
}
