package com.vtxlab.app.revision;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerHolder {
  public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4);
    List<Integer> integers2 = integers.stream().filter(e -> e % 2 == 0)
        .collect(Collectors.toList());
  }
}
