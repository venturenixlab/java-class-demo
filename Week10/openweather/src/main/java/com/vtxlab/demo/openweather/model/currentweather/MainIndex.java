package com.vtxlab.demo.openweather.model.currentweather;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainIndex {

  @JsonProperty("temp")
  private BigDecimal temperature;

  /**
   *  Accounts for the human perception of weather.
   */
  @JsonProperty("feels_like")
  private BigDecimal feelLikeTemperature;

  @JsonProperty("temp_min")
  private BigDecimal minTemperature;

  @JsonProperty("temp_max")
  private BigDecimal maxTemperature;

  private BigDecimal pressure;

  private BigDecimal humidity;

}
