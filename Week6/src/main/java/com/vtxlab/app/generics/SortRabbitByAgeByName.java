package com.vtxlab.app.generics;

import java.util.Comparator;

public class SortRabbitByAgeByName implements Comparator<Rabbit> {
  @Override
  public int compare(Rabbit o1, Rabbit o2) {
    if (o1.getAge() == o2.getAge()) {
      if (o1.getName().compareTo(o2.getName()) == -1) {
        return -1;
      }
    }
    // System.out.println(Integer.compare(o1.getAge(), o2.getAge()));
    return Integer.compare(o1.getAge(), o2.getAge());
  }
}
