package com.vtxlab.app.poly;

public class ParentClass {
  static final boolean IS_SUNDAY_HOLIDAY = true; // i don't want someone else to update false
  static boolean IS_SUNDAY_HOLIDAY2 = true; // can be updated to false
  final boolean IS_SUNDAY_HOLIDAY3 = true; // its ok, but slower

  public void doSomething() {
    System.out.println("i am parent");
    System.out.println(IS_SUNDAY_HOLIDAY); // faster
    System.out.println(IS_SUNDAY_HOLIDAY3); // slower
  }

  // public abstract void swim();
}
