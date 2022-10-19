final class Constant { // static class
  public static final int DAYS_IN_WEEK = 7; // static final
  public static int SECONDS_IN_MINUTE = 31; // static final, non-final
  public final int HOURS_IN_DAY = 24; // non-static, final
  public int MINS_IN_HOUR = 60; // non-static, non-final
}

class DemoConstant {
  public static void main(String[] args) {
    System.out.println(Constant.DAYS_IN_WEEK);
    // System.out.println(Constant.HOURS_OF_DAY); // compile error, non-static should be accessed by instance
    // System.out.println(Constant.MINS_OF_HOUR); // compile error, non-static should be accessed by instance
    System.out.println(Constant.SECONDS_IN_MINUTE);
    Constant.SECONDS_IN_MINUTE = 70; // Class variable, non-final, can be modified by Class

    Constant constant = new Constant();
    System.out.println(constant.HOURS_IN_DAY);
    System.out.println(constant.MINS_IN_HOUR);
    constant.MINS_IN_HOUR = 59; // non-final and non-static, its ok to modify value by instance
    // constant.SECONDS_IN_MINUTE = 59; // Compile error. its static, not accessed by instance
    // constant.HOURS_IN_DAY = 23; // Compile error. its final field, cannot be modified after initialization
    // constant.DAYS_IN_WEEK = 6; // Compile error. Same as the above

  }
}
