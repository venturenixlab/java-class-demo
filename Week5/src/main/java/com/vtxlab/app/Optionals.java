package com.vtxlab.app;

import java.util.Optional;

public class Optionals {

  public String getName() {
    return "Tommy";
  }

  public static Optional<String> getOptionalName() {
    // access Database, get value
    // return Optional.of("Tommy");
    // return Optional.empty();
    return Optional.ofNullable(null);
  }

  public static void main(String[] args) {

    Optional<String> s = getOptionalName();

    String s2 = s.orElse("Steve"); // NoSuchElementException: No value present
    System.out.println(s2);

    s.ifPresent(e -> {
      System.out.println(s.get()); // another runtime exception
    });
    ; // NoSuchElementException: No value present

    Optional<String> opt2 = Optional.ofNullable(null);
    String defaultWithOrElse2 = opt2.orElse("default value");
    System.out.println(defaultWithOrElse2); // prints "default value"

    s.ifPresent(e -> {
      System.out.println(e.length());
    }); // ifPresent -> Consumer (void)

  }
}
