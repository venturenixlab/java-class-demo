package com.vtxlab.demo.openweather.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.openweather.controller.WeatherOperations;
import com.vtxlab.demo.openweather.model.currentweather.CurrentWeatherResponse;
import com.vtxlab.demo.openweather.model.dto.WeatherDto;
import com.vtxlab.demo.openweather.response.Alert;
import com.vtxlab.demo.openweather.response.ApiResponse;
import com.vtxlab.demo.openweather.response.enums.ResponseStatus;
import com.vtxlab.demo.openweather.service.OpenWeatherService;
import com.vtxlab.demo.openweather.utils.WeatherModelMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class WeatherController implements WeatherOperations {

        @Autowired
        OpenWeatherService openWeatherService;

        public static List<Alert> errAlerts = new ArrayList<>();

        @Override
        public ResponseEntity<ApiResponse<WeatherDto>> getWeatherData(
                        BigDecimal lantitude,
                        BigDecimal longitude) throws Exception {
                CurrentWeatherResponse currentWeatherResponse = openWeatherService
                                .getCurrentWeather(lantitude, longitude);

                Integer responseCode = currentWeatherResponse.getCode() == 200 ? //
                                ResponseStatus.OK.getCode()
                                : ResponseStatus.THIRD_PARTY_API_FAIL.getCode();

                String responseMsg = currentWeatherResponse.getCode() == 200 ? //
                                ResponseStatus.OK.getMessage()
                                : ResponseStatus.THIRD_PARTY_API_FAIL
                                                .getMessage();

                WeatherDto weatherDto = WeatherModelMapper
                                .convert(currentWeatherResponse);

                ApiResponse<WeatherDto> apiResponse = ApiResponse
                                .<WeatherDto>builder()
                                .code(responseCode)
                                .message(responseMsg)
                                .data(weatherDto)
                                .alerts(errAlerts)
                                .build();

                return ResponseEntity.ok().body(apiResponse);
        }

}
