package com.vtxlab.demo.openweather.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDto {

  CurrentWeatherDto currentWeatherDto;
  
}
