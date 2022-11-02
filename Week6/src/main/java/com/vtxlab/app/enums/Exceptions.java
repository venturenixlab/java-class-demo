package com.vtxlab.app.enums;

public enum Exceptions {
  // Timeout Exception
  TIMEOUT(1000, "Exception - Time out!"), CUSTOMER_WEBSITE_TIMEOUT(1001,
      "Exception - Customer website Time out!"),
  // Duplicated Records
  DUPLICATED_RECORD(2000, "Exception - Duplicated Record!"),

  // Bad Gateway
  BAD_GATEWAY(3000, "Exception - Bad Gateway!"),

  // Token Expiry
  TOKEN_EXPIRE(4000, "Exception - Token Expire!"),

  // NPE
  NPE(5000, "Runtime Exception - Null Pointer Exception!"),
  ;

  private int code;
  private String exceptionMsg;

  public int getCode() {
    return this.code;
  }

  public static void getReturnValue() {
    int i = 0;
    if (i == 0) { // early return
      return;
    }
    int b = 9; //
    int c = 4; //
    // return;
    // double b = 0;
  }

 

  public String getExceptionMsg() {
    return this.exceptionMsg;
  }

  private Exceptions(int code, String msg) {
    this.code = code;
    this.exceptionMsg = msg;
  }

}
