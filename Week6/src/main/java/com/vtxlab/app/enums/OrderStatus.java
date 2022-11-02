package com.vtxlab.app.enums;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

enum OrderStatus {
  ORDERED(1), PAID(2), READY_TO_SHIP(3), DELIVERED(4), DEFAULT(99);
  ;

  private int code;

  private OrderStatus(int code) {
    this.code = code;
  }

  public static OrderStatus fromCode(int code) {
    for (OrderStatus o : OrderStatus.values()) {
      if (o.code == code) {
        return o;
      }
    }
    return OrderStatus.DEFAULT;
  }

  public static OrderStatus fromCode2(int code) {
    // Stream
    // OrderStatus.values() returns OrderStatus[]
    // FindFirst() -> return ?
    // if not found?
    // throw OrderStatus.DEFAULT
    // Optional.orElse
    return Arrays.stream(OrderStatus.values()) //
        .filter(e -> e.code == code) //
        .findFirst().orElse(OrderStatus.DEFAULT);
  }

  public static Optional<OrderStatus> fromCode3(int code) {

    Predicate<OrderStatus> codeEquals = e -> e.code == code;

    return Arrays.stream(OrderStatus.values()) //
        .filter(codeEquals) //
        .findFirst();
    // .orElseThrow(() -> new NullPointerException());
  }

}
