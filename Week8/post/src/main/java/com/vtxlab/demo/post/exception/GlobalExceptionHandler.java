package com.vtxlab.demo.post.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.demo.post.response.ApiResponse;

@ControllerAdvice // Spring bean
public class GlobalExceptionHandler<T> {

  @ExceptionHandler({ KeyExistException.class })
  public ResponseEntity<ApiResponse<T>> handleKeyExistException() {
    return ResponseEntity.badRequest().body(new ApiResponse<>(13001,
        "key already exists", null));
  }

  @ExceptionHandler({ NullPointerException.class })
  public ResponseEntity<ApiResponse<T>> handleNpeException() {
    return ResponseEntity.badRequest().body(new ApiResponse<>(13002,
        "NPE, sorry", null));
  }

  @ExceptionHandler({ KeyNotFoundException.class })
  public ResponseEntity<ApiResponse<T>> handleKeyNotFoundException() {
    return ResponseEntity.badRequest().body(new ApiResponse<>(13003,
        "Key Not Found Exception, please check", null));
  }

  @ExceptionHandler({ IllegalArgumentException.class })
  public ResponseEntity<ApiResponse<T>> handleIaeException() {
    return ResponseEntity.badRequest().body(new ApiResponse<>(13004,
        "IA Exception, sorry", null));
  }

  @ExceptionHandler({ Exception.class })
  public ResponseEntity<ApiResponse<T>> handleException() {
    return ResponseEntity.badRequest().body(new ApiResponse<>(13999,
        "Exception, sorry", null));
  }
  
}
