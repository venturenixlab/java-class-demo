package com.vtxlab.demo.openweather.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDto {

  @JsonProperty("currentWeather")
  CurrentWeatherDto currentWeatherDto;
  
}
