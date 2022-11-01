package com.vtxlab.app.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rabbit implements Comparable<Rabbit> {
  private int age;
  private String name;

  public Rabbit(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public int compareTo(Rabbit r) {
    return Integer.compare(this.age, r.age);
  }

  public static void main(String[] args) {
    List<Integer> integers = new ArrayList<>();
    List<int[]> integerArray = new ArrayList<>();

    Map<Integer, Rabbit> rabbitMap = new HashMap<>();
    Rabbit rabbit1 = new Rabbit(13, "Benson");
    rabbitMap.put(1, rabbit1);

    rabbitMap.forEach((a, b) -> {
      System.out.println(b);
    });

    for (Map.Entry<Integer, Rabbit> entry : rabbitMap.entrySet()) {
      System.out.println(entry.getValue());
    }

    List<Rabbit> rabbitArray = new ArrayList<>();
    Collections.sort(rabbitArray);

    List<Rabbit> rabbitArray2 = new ArrayList<>();

    rabbitArray2.add(rabbit1);
    rabbitArray2.add(new Rabbit(2, "Mary"));
    rabbitArray2.add(new Rabbit(13, "Alex"));
    rabbitArray2.add(new Rabbit(4, "Zoom"));
    rabbitArray2.add(new Rabbit(13, "Cat"));
    Collections.sort(rabbitArray2, new SortRabbitByAgeByName());

    rabbitArray2.forEach(e -> {
      System.out.println(e.getName());
    });
  }

}
