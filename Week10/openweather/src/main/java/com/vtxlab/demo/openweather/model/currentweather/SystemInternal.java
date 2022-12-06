package com.vtxlab.demo.openweather.model.currentweather;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemInternal implements Serializable { // sys
  
  /**
   * Internal parameter
   */
  BigDecimal type;

  /**
   * Internal parameter
   */
  BigDecimal id;

  /**
   * Internal parameter
   */
  BigDecimal message;

  /**
   * Country code (GB, JP etc.)
   */
  @JsonProperty("country")
  String countryCode;

  /**
   * Sunrise time, unix, UTC
   */
  @JsonProperty("sunrise")
  BigDecimal sunriseTime;

  /**
   * Sunset time, unix, UTC
   */
  @JsonProperty("sunset")
  BigDecimal sunsetTime;

}