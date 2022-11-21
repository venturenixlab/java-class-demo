package com.vtxlab.demo.stock.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.stock.controller.StockOperation;
import com.vtxlab.demo.stock.entity.Stock;
import com.vtxlab.demo.stock.model.StockDto;
import com.vtxlab.demo.stock.response.ApiResponse;
import com.vtxlab.demo.stock.service.StockService;

@RestController
@RequestMapping(value = "/api/v1")
public class StockController implements StockOperation {

  @Autowired
  StockService stockService;

  @Override
  public ResponseEntity<ApiResponse<List<Stock>>> findStocks() {
    ApiResponse<List<Stock>> response = ApiResponse.<List<Stock>>builder()//
        .code(200)
        .message("OK")
        .data(stockService.findStocks())
        .build();

    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<List<StockDto>>> findStockDtos() {
    ApiResponse<List<StockDto>> response = ApiResponse.<List<StockDto>>builder()//
        .code(200)
        .message("OK")
        .data(stockService.findStockDtos())
        .build();

    return ResponseEntity.ok().body(response);
  }
}
