package com.vtxlab.app;

import java.util.Objects;
import java.util.Optional;

public class OptionalTest {

  public static Optional<String> getName() {
    // return null;
    return Optional.ofNullable(null);
  }

  public static String getName2() {
    return null;
  }

  public static void main(String[] args) {

    if (!Objects.isNull(OptionalTest.getName())) { // avoid NPE
      int stringLength = getName2().length();
    }

    System.out.println(OptionalTest.getName());

    OptionalTest.getName().ifPresent(e -> {
      System.out.println(e);
    });

    Integer i = Integer.valueOf("abc"); // Nunberformat

  }
}
