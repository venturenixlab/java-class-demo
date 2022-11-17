package com.vtxlab.demo.post.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.demo.post.respsonse.ApiResponse;

@ControllerAdvice // Spring bean
public class GlobalExceptionHandler<T> {

  @ExceptionHandler({ KeyExistException.class })
  public ResponseEntity<ApiResponse<T>> handleKeyExistException() {
    return ResponseEntity.badRequest().body(new ApiResponse<>(13001,
        "key already exists", null));
  }
}
