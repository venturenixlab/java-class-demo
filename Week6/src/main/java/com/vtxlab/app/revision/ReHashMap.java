package com.vtxlab.app.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.JSpinner.NumberEditor;

public class ReHashMap {
  public static void main(String[] args) {

    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 100); // map put, but not add
    map.put(3, 300); // map put, but not add
    map.get(3); // return 300
    map.remove(3); // remove by key

    Map<Integer, String> map2 = new HashMap<>();
    map2.put(3, "Tommy");
    map2.put(3, "Sunny");
    map2.put(4, null);
    map2.put(null, "Gary");
    // throw new IllegalAccessException(); // error

    // System.out.println(map.toString());
    Hashtable<Integer, String> table = new Hashtable<>();
    table.put(3, "Tommy");
    table.put(7, "Steve");

    Integer key = null;
    Optional<Integer> optInt = Optional.ofNullable(key);
    // key = key == null ? 0 : key;
    optInt.ifPresent(i -> {
      table.get(i);
    });

    System.out.println(table.toString()); // runtime exception

    // map.computeIfPresent(null, null)

    Map<Integer, NumberHolder<Number>> mapOfList = new HashMap<>();

  }
}
