package com.vtxlab.app.revision;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReGeneric {

  public static <T> List<T> fromArrayToList(T[] a) {
    return Arrays.stream(a).collect(Collectors.toList());
  }

  public static <T> long listCount(List<T> a) {
    return a.stream().count();
  }

  public static void main(String[] args) {
    Integer[] intArray = { 1, 2, 3 };

    List<Integer> integers = ReGeneric.fromArrayToList(intArray);
    ReGeneric.listCount(integers);
  }
}
