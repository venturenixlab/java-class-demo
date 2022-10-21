package com.vtxlab.app;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class DemoHashSet {
  public static void main(String[] args) {

    Queue<Integer> q = new LinkedList<>();
    q.remove();
    q.add(null);
    q.poll();
    q.stream().forEach(null);
    q.forEach(null);

    String newString = "Hello";
    newString = newString.concat("World");
    newString = newString + "World";

    Set<String> hs = new TreeSet<>();

    hs.add("A");
    hs.add("C");
    hs.add("B123");
    hs.add("E");
    hs.add("D");
    hs.add("D123ss");
    hs.add("E");
    hs.add("B");

    System.out.println("Initial HashSet " + hs);

  }
}
