package object;

class FireFighter {
  private int hoursOfTraining; // arttribute or state
  private int age; // arttribute or state
  private String sex; // arttribute or state

  // constructor
  public FireFighter() {
  }

  // initialization
  public FireFighter(int a, int b, String c) {
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
