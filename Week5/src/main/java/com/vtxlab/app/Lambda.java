package com.vtxlab.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.var;

public class Lambda {
  public static void main(String[] args) {
    Map<Integer, Integer> nameLengthMap = new HashMap<>();
    // nameLengthMap.put(12, 100);

    // We are writing a formula to calculate the length of input "String"
    Function<Integer, Integer> computeLength = s -> 0;

    // 1. check if the key exists in the map
    // 2. if no, calculate value according to my formula
    // 3. put the key & value (entry) to the map
    Integer computedValue = nameLengthMap.computeIfAbsent(12, computeLength);

    System.out.println(computedValue);

    System.out.println(nameLengthMap.get(12));

    // BuFunction
    Map<String, Integer> nameFrequencyMap = new HashMap<>();
    nameFrequencyMap.put("Peter", 3);

    // equivalent to (oldValue, newValue) -> oldValue + newValue
    // BiFunction<Integer, Integer, Integer> mergeFrequencyByName = Integer::sum;
    BiFunction<Integer, Integer, Integer> mergeFrequencyByName = (a, b) -> {
      return a + b;
    };

    // 1. "Peter" is a key to find the value in the map.entry
    // 2. Then compute the return value and second parameter according to my formula
    // 3. 3 + 4 = 7
    // 4. Finally update the value to 7 for key "Peter"
    Integer mergedValue = nameFrequencyMap.merge("Peter", 4, mergeFrequencyByName);

    System.out.println(mergedValue); // 7
    System.out.println(nameFrequencyMap); // 7

    Predicate<String> startsWithV = (a) -> a.startsWith("V");
    Predicate<String> endsWithT = (x) -> x.endsWith("T");

    Predicate<String> combined = startsWithV.and(endsWithT);
    Predicate<String> combined2 = startsWithV.or(endsWithT);
    System.out.println(combined.test("VINCENT")); // prints true
    System.out.println(combined2.test("OINCENM")); // prints false

    List<String> names = Arrays.asList("Peter", "Paul", "Mary");

    List<Integer> integers = Arrays.asList(1, 5);

    // lambda passed in as *Consumer*
    Consumer<String> printName = name -> System.out.println("Hello " + name);
    Consumer<Integer> printInteger = integer -> System.out.println("Hello " + integer);

    names.forEach(printName);
    integers.forEach(printInteger);

    names.forEach(element -> {
      System.out.println("Hello " + element);
      System.out.println("Hello2 " + element);
    });

    Map<String, Integer> ages = new HashMap<>();
    ages.put("Peter", 18);
    ages.put("Paul", 19);
    ages.put("Mary", 20);

    // lambda passed in as BiConsumer
    // BiConsumer<String, Integer> printNameAndAge = (name, age) ->
    // System.out.println(name + " is " + age + " years old");
    // ages.forEach(printNameAndAge);

    // for loop
    ages.forEach((name, age) -> {
      ages.put("Peter", 20);
      System.out.println(name + " is " + age + " years old");
    }); // loop 3 times
    // Copy the map again
    ages.forEach((name, age) -> {
      System.out.println(name + " is " + age + " years old");
    });

    // for (Map.Entry<String, Integer> abc : ages.entrySet()) {
    // System.out.println("dosomething else");
    // }

    List<String> names2 = Arrays.asList("Alex", "Amy", "Ben", "Charlotte", "Dicky");

    //
    Predicate<String> startsWithA = n -> n.startsWith("A");

    if (startsWithA.test("Alex")) {
      System.out.println("Yes");
    }

    for (String name : names2) {
      if (startsWithA.test(name)) {
        System.out.println(name);
      }
    }

  }
}
