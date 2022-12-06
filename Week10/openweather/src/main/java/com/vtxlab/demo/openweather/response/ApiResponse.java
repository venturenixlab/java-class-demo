package com.vtxlab.demo.openweather.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {

  /**
   * !HttpStatus. Instead, its internal response code, controlled by enum.
   */
  private Integer code;

  /**
   * !HttpsStatus message.
   * Instead, its internal response message, controlled by enum.
   */
  private String message;

  /**
   * Able to map any type, but not primitive.
   */
  private T data;

  /**
   * Includes warning and error.
   */
  private List<Alert> alerts;

}
