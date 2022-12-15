package com.vtxlab.crypto.polygon.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.crypto.polygon.exception.ApiException;
import com.vtxlab.crypto.polygon.model.dto.ChannelDto;

@RequestMapping(value = "/default")
public interface PolygonOperations {

  @GetMapping(value = "/price")
  ChannelDto getExchangeRate(
      @RequestParam(value = "coins") List<String> cryptos,
      @RequestParam List<String> currencies) throws ApiException;

}
