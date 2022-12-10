package com.vtxlab.demo.validation.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.demo.validation.model.Payment;
import com.vtxlab.demo.validation.responses.ApiResponse;

@ControllerAdvice // Spring bean
public class GlobalExceptionHandler {

  @ExceptionHandler({ MethodArgumentNotValidException.class })
  /// @org.springframework.web.bind.annotation.ResponseStatus(code =
  /// HttpStatus.bad)
  public ResponseEntity<ApiResponse<Payment>> handleMethodArgumentException(
      MethodArgumentNotValidException e) {
    ApiResponse<Payment> apiResponse = ApiResponse.<Payment>builder()
        .code(e.getStatusCode().value())
        .message(e.getAllErrors().get(0).getDefaultMessage())
        .data(null)
        .build();

    return ResponseEntity.badRequest().body(apiResponse);
  }

}
