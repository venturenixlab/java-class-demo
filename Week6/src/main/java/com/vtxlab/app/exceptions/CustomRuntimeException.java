package com.vtxlab.app.exceptions;

public class CustomRuntimeException extends RuntimeException {
  // CustomRuntimeException is an unchecked exception

  public CustomRuntimeException(String s) {
    super(s);
  }
  
}
