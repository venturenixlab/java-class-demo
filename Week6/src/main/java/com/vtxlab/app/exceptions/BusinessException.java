package com.vtxlab.app.exceptions;

// checked exception
// company level
public class BusinessException extends Exception {

  public BusinessException() {
    super();
  }

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
  }
}
