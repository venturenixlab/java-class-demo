package com.vtxlab.app;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lambda2 {
  public static void main(String[] args) {
    Function<Integer, String> function = (i) -> "abc";

    Function<Integer, int[]> f2 = (a) -> new int[] { 1, 2, 3 };

    Function<Integer, Map<String, String>> f3 = (b) -> new HashMap<>();

    Function<Integer, int[]> f4 = (a) -> {
      if (a == 4) {
        return new int[] { 1, 2, 3 };
      }
      return new int[] { 1, 2, 3 };
    };

    // implement the logic for the method Function.apply()
    Function<Integer, int[]> arrayWithSize = (a) -> new int[a];

    int[] integers = arrayWithSize.apply(5);

    BiFunction<Integer, Integer, Double[]> arrayWithSize2 = (a, b) -> new Double[a + b];

    Double[] arr = arrayWithSize2.apply(4, 5);

    Function<Integer, Integer> randomNumber = (range) -> (int) (Math.random() * range);
    System.out.println(randomNumber.apply(1000));

    Function<Long, LocalDate> nextWeek = (days) -> LocalDate.now().plusDays(days);
    System.out.println(nextWeek.apply(7l));

    Supplier<LocalDate> SevenDaysLater = () -> LocalDate.now().plusDays(7l);
    System.out.println(SevenDaysLater.get());

    Consumer<Object> number = x -> {
      if (x instanceof Number) { // check if x is a child class of Number
        System.out.println(x.toString()); // print value of x
        System.out.println(((Number) x).intValue());
      }
    };
    number.accept("abc");
    number.accept(5);
    number.accept(new int[] { 1, 2, 3 });

  }
}
