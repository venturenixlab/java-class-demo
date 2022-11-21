package com.vtxlab.demo.stock.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.stock.entity.Stock;
import com.vtxlab.demo.stock.model.StockDto;
import com.vtxlab.demo.stock.response.ApiResponse;

@RequestMapping(value = "default")
public interface StockOperation {

  @GetMapping(value = "/stocks")
  ResponseEntity<ApiResponse<List<Stock>>> findStocks();

  @GetMapping(value = "/stockDtos")
  ResponseEntity<ApiResponse<List<StockDto>>> findStockDtos();
  
}
