package com.vtxlab.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import com.vtxlab.model.customer.Customer;

public class Lambda2 {

  /**
   * TBC.
   * 
   * @param customer tbc
   * @return tbc
   */
  public String getString(Customer customer) {
    return customer == null ? null : customer.getName();
    // return customer.getName();
  }

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

    UnaryOperator<String> string = x -> {
      return x.toLowerCase();
    };
    // if and only if the implemention can be completed in one line
    // skip bracket and return keyword
    UnaryOperator<String> toLowerCase = x -> x.toLowerCase();
    UnaryOperator<String> replaceCWithA = x -> {
      // ...
      return x.replace("c", "a");
    };

    String s = toLowerCase.apply("CCC"); // CCC -> ccc
    String s2 = toLowerCase.andThen(replaceCWithA).apply("CCC"); // CCC -> ccc -> aaa
    System.out.println(s2);

    String s4 = "CCC".toLowerCase(); // equals to line 63
    String s3 = s.toLowerCase();

    Animal drink1 = x -> x.toUpperCase(); // provide implementation to drink()
    Animal drink2 = x -> x.toLowerCase(); // provide implementation to drink()
    String a = drink1.drink("WATER"); // WATER -> WATER
    String a2 = drink2.drink("WATER"); // WATER -> water

    BinaryOperator<int[]> mergeIntArray = (x, y) -> {
      int[] z = new int[x.length + y.length];
      for (int i = 0; i < x.length; i++) {
        z[i] = x[i];
      }
      for (int j = 0; j < y.length; j++) {
        z[x.length + j] = y[j];
      }
      return z;
    };
    int[] newArray = mergeIntArray.apply(new int[] { 3, 1 }, new int[] { 10, 20 });
    // Arrays.sort(newArray);
    // count how many 0 of newArray currenly has
    int count = 0;
    for (int k = 0; k < newArray.length; k++) {
      if (newArray[k] == 0) {
        count++;
      }
    }
    int[] o = new int[newArray.length - count]; // 0,0,0,0,0,0,0

    int c = 0;
    for (int j = 0; j < newArray.length; j++) {
      if (newArray[j] != 0) {
        o[c] = newArray[j];
        c++;
      }
    }
    Arrays.sort(o);

    System.out.println(Arrays.toString(o));

    // Predicate
    Predicate<String> lengthSmallerThan5 = x -> x.length() < 5;
    System.out.println(lengthSmallerThan5.test("abc1")); // true
    System.out.println(lengthSmallerThan5.test("abcde")); // false

    BiPredicate<String, String> compareStringHash = (x, y) -> x.hashCode() == y.hashCode();
    System.out.println(compareStringHash.test("abc", "abc")); // true
    System.out.println(compareStringHash.test("abc", "abcd")); // false
    // Predicate<String> f = x -> x. < 5;

    String s10 = "abcd";
    System.out.println(s10.hashCode());

    String s9 = ""; // it is blank and empty
    String s8 = "null";
    String s7 = "null ";
    String s6 = "  ";
    String s5 = null;
    // s9
    if (!Objects.isNull(s9)) {
      System.out.println("s9 is blank" + s9.isBlank()); // true
      System.out.println("s9 is empty" + s9.isEmpty()); // true
    }
    if (!Objects.isNull(s8)) {
      System.out.println("s8 is empty" + s8.isEmpty()); // false
      System.out.println("s8 is blank" + s8.isBlank()); // false
    }
    if (!Objects.isNull(s7)) {
      System.out.println("s7 is blank" + s7.isBlank()); // false
      System.out.println("s7 is empty" + s7.isEmpty()); // false
    }
    if (!Objects.isNull(s6)) {
      System.out.println("s6 is blank" + s6.isBlank()); // true
      System.out.println("s6 is empty" + s6.isEmpty()); // false
    }
    if (!Objects.isNull(s5)) {
      System.out.println("s5 is blank" + s5.isBlank()); // true
      System.out.println("s5 is empty" + s5.isEmpty()); // false
    } else {
      System.out.println("s5 is null");
    }
    // Team+timestamp+ipaddres+"5"
    // 10020221028111002999900000
    //

    long streamCount = Stream.of(1, 2, 3).map(i -> {
      System.out.println(i); // didnot print i
      return i + 1;
    }).count();

    System.out.println(streamCount);

  }
}
