package com.vtxlab.demo.post.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.demo.post.respsonse.ApiResponseException;

@ControllerAdvice // Spring bean
public class GlobalExceptionHandler {

  @ExceptionHandler({ KeyExistException.class })
  public ResponseEntity<ApiResponseException> handleKeyExistException() {
    ApiResponseException exception = new ApiResponseException(13001,
        "key already exists");
    return ResponseEntity.badRequest().body(exception);
  }
}
