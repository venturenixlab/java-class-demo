package com.vtxlab.demo.openweather.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.demo.openweather.controller.impl.WeatherController;
import com.vtxlab.demo.openweather.response.Alert;
import com.vtxlab.demo.openweather.response.ApiResponse;
import com.vtxlab.demo.openweather.response.enums.ResponseStatus;

@ControllerAdvice // Spring bean
public class GlobalExceptionHandler<T> {

  @ExceptionHandler({ ApiException.class })
  public ResponseEntity<ApiResponse<T>> handleApiException(ApiException e) {
    WeatherController.errAlerts.add(new Alert(e.getCode(), e.getMessage()));

    return ResponseEntity.badRequest()
        .body(
            new ApiResponse<>(ResponseStatus.THIRD_PARTY_API_TIMEOUT.getCode(),
                ResponseStatus.THIRD_PARTY_API_TIMEOUT.getMessage(), //
                null,
                WeatherController.errAlerts));
  }

  @ExceptionHandler({ NullPointerException.class })
  public ResponseEntity<ApiResponse<T>> handleNpeException() {
    return ResponseEntity.badRequest().body(
        new ApiResponse<>(ResponseStatus.NPE.getCode(),
            ResponseStatus.NPE.getMessage(), //
            null,
            WeatherController.errAlerts));
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
