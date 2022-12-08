package com.vtxlab.demo.openweather.response.enums;

import lombok.Getter;

@Getter
public enum ResponseStatus {
  // Success 20000 - 29999
  OK(20000, "Success."),
  // 20001 ...
  // Fail 30000 - 39999
  FAIL(30000, "Fail."), //
  THIRD_PARTY_API_FAIL(30001, "Third Party API Fail."), //
  THIRD_PARTY_API_TIMEOUT(30002, "Third Party API Timeout."),
  // Runtime Exception 70000 - 71000
  NPE(70000, "Nullpointer Exception."),
  AME(70001, "Arithmetic Exception.");

  Integer code;
  String message;

  ResponseStatus(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

}
