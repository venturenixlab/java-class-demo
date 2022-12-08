package com.vtxlab.demo.openweather.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vtxlab.demo.openweather.response.ResponseData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDto extends ResponseData {

  @JsonProperty("currentWeather")
  CurrentWeatherDto currentWeatherDto;

  public WeatherDto(String teamCode, LocalDateTime datetime,
      CurrentWeatherDto currentWeatherDto) {
    super(teamCode, datetime);
    this.currentWeatherDto = currentWeatherDto;
  }

}
