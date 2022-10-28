package com.vtxlab.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Streams {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Peter", "Carl", "Benny", "Benny", "Alex");

    Predicate<String> containC = e -> e.contains("C");
    Predicate<String> containB = e -> e.contains("B");
    Predicate<String> lengthLessThan5 = e -> e.length() < 5;

    UnaryOperator<String> toUpperCase2 = e -> e.toUpperCase();
    Function<String, String> returnSelf = e -> e;
    Function<String, String> toUpperCase = e -> e.toUpperCase();
    Function<String, String> toSubstring = e -> e.substring(0, 3);

    // filtering
    Set<String> newNames = names.stream()
        .map(toUpperCase2.andThen(toSubstring)) // on sequence
        .filter(containB.and(lengthLessThan5)) // intermediate operation
        .sorted()
        .collect(Collectors.toSet()); // terminal operation
    System.out.println(newNames);

    Set<String> removeDuplicated = names.stream().collect(Collectors.toSet());
    System.out.println(removeDuplicated);

    // stream.iterate()
    List<Integer> numbers = Stream.iterate(1, n -> n + 1) // intermediate operation
        .limit(10) // intermediate operation
        .collect(Collectors.toList()); // terminal operation

    System.out.println(numbers); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    // stream.reduce()
    Integer reduced = numbers.stream() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        .reduce(0, (a, b) -> a + b); // terminal operation
    System.out.println(reduced); // 55

    List<Integer> numberlist = Arrays.asList(9992, 2121, 2184, 5539, 3120);

    Optional<Integer> optional = numberlist.stream()
        .min((o1, o2) -> o1.compareTo(o2)); // terminal operation

    optional.ifPresent(e -> {
      System.out.println(e);
    });

    // System.out.println(filteredNames); // [Alex]
  }
}
