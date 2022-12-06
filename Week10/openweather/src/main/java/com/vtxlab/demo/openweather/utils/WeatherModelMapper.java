package com.vtxlab.demo.openweather.utils;

import com.vtxlab.demo.openweather.model.currentweather.CurrentWeatherResponse;
import com.vtxlab.demo.openweather.model.dto.CurrentWeatherDto;
import com.vtxlab.demo.openweather.model.dto.WeatherDto;

public class WeatherModelMapper {

  public static WeatherDto convert(CurrentWeatherResponse cwr) {
    if (cwr == null) {
      return null;
    }
    CurrentWeatherDto currentWeatherDto = //
        CurrentWeatherDto.builder()
            .latitude(cwr.getCoordinate().getLatitude())
            .longitude(cwr.getCoordinate().getLongitude())
            .cityId(cwr.getCityId())
            .cityName(cwr.getCityName())
            .humidity(cwr.getMainIndex().getHumidity())
            .cloudinessPercent(cwr.getCloudIndex().getCloudinessPercent())
            .build();

    return WeatherDto.builder().currentWeatherDto(currentWeatherDto).build();
  }
}
