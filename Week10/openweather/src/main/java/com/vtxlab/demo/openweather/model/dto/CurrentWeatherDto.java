package com.vtxlab.demo.openweather.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrentWeatherDto {

  private BigDecimal latitude;

  private BigDecimal longitude;

  private BigDecimal datatime;

  private BigDecimal timezone;

  private BigDecimal cityId;

  private String cityName;

  private BigDecimal temperature;

  private BigDecimal minTemperature;

  private BigDecimal maxTemperature;

  private BigDecimal pressure;

  private BigDecimal humidity;

  private BigDecimal windSpeed;

  private BigDecimal windDegree;

  private BigDecimal cloudinessPercent;

}
