package com.vtxlab.model.generics;

public abstract class Shape {
  public String color;

  public static <T extends Shape & Area> double calcArea(T t) {
    // 1000 line of code
    // Shape -> color
    return t.area();
  }

  public static double calcArea(Area s) {
    return s.area();
  }
}
