package com.vtxlab.app;

import java.util.List;

public class CustomException extends RuntimeException {

  String anotherMsg;

  public String getAnotherMsg() {
    return this.anotherMsg;
  }

  public CustomException(String msg) {
    super(msg);
  }

  public CustomException(String msg, List<String> strings) {
    super(msg);
    strings.forEach(e -> this.anotherMsg += e);
  }

}
