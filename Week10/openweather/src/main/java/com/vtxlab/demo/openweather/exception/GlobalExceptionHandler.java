package com.vtxlab.demo.openweather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.demo.openweather.model.dto.WeatherDto;
import com.vtxlab.demo.openweather.response.Alert;
import com.vtxlab.demo.openweather.response.ApiResponse;
import com.vtxlab.demo.openweather.response.ResponseData;
import com.vtxlab.demo.openweather.response.enums.ResponseStatus;
import com.vtxlab.demo.openweather.utils.WeatherApi;

@ControllerAdvice // Spring bean
public class GlobalExceptionHandler {

  @ExceptionHandler({ ApiException.class })
  /// @org.springframework.web.bind.annotation.ResponseStatus(code =
  /// HttpStatus.bad)
  public ResponseEntity<ApiResponse<? extends ResponseData>> handleApiException(
      ApiException e) {
    WeatherApi.setAlerts(new Alert(e.getCode(), e.getMessage()));

    return ResponseEntity.badRequest()
        .body(
            new ApiResponse<>(ResponseStatus.THIRD_PARTY_API_TIMEOUT.getCode(),
                ResponseStatus.THIRD_PARTY_API_TIMEOUT.getMessage(), //
                new ResponseData(),
                WeatherApi.getAlerts()));
  }

  @ExceptionHandler({ NullPointerException.class, ArithmeticException.class })
  public ResponseEntity<ApiResponse<? extends ResponseData>> handleRuntimeException(
      RuntimeException e) {
    Integer code = null;
    String message = "";
    if (e instanceof NullPointerException) {
      code = ResponseStatus.NPE.getCode();
      message = ResponseStatus.NPE.getMessage();
    } else if (e instanceof ArithmeticException) {
      code = ResponseStatus.AME.getCode();
      message = ResponseStatus.AME.getMessage();
    }
    return ResponseEntity.badRequest().body(
        new ApiResponse<>(code,
            message, //
            null,
            WeatherApi.getAlerts()));
  }

  /*
   * @ExceptionHandler({ NullPointerException.class })
   * public ResponseEntity<ApiResponse<T>> handleNpeException() {
   * return ResponseEntity.badRequest().body(new ApiResponse<>(13002,
   * "NPE, sorry", null));
   * }
   * 
   * @ExceptionHandler({ KeyNotFoundException.class })
   * public ResponseEntity<ApiResponse<T>> handleKeyNotFoundException() {
   * return ResponseEntity.badRequest().body(new ApiResponse<>(13003,
   * "Key Not Found Exception, please check", null));
   * }
   * 
   * @ExceptionHandler({ IllegalArgumentException.class })
   * public ResponseEntity<ApiResponse<T>> handleIaeException() {
   * return ResponseEntity.badRequest().body(new ApiResponse<>(13004,
   * "IA Exception, sorry", null));
   * }
   */

}
