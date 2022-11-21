package com.vtxlab.demo.stock.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.demo.stock.response.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler<T> {

  @ExceptionHandler({ RecordNotFoundException.class })
  public ResponseEntity<ApiResponse<T>> handleRecordNotFoundException() {
    ApiResponse<T> response = ApiResponse.<T>builder()//
        .code(13001)
        .message("Record Not Found, sorry")
        .data(null)
        .build();

    return ResponseEntity.badRequest().body(response);
  }
}
