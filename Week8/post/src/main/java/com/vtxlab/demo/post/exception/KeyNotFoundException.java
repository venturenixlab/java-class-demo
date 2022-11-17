package com.vtxlab.demo.post.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KeyNotFoundException extends RuntimeException {

  private int code;

  public KeyNotFoundException(int code, String message) {
    super(message);
    this.code = code;
  }
}
