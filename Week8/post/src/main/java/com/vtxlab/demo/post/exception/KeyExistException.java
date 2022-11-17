package com.vtxlab.demo.post.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KeyExistException extends Exception {

  private int code;

  public KeyExistException(int code, String msg) {
    super(msg);
    this.code = code;
  }
}
