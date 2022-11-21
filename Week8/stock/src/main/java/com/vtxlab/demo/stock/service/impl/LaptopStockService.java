package com.vtxlab.demo.stock.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.stock.entity.Stock;
import com.vtxlab.demo.stock.exception.RecordNotFoundException;
import com.vtxlab.demo.stock.model.StockDto;
import com.vtxlab.demo.stock.repository.StockRepository;
import com.vtxlab.demo.stock.service.StockService;

@Service
public class LaptopStockService implements StockService {

  @Autowired
  StockRepository stockRepository;

  @Override
  public List<Stock> findStocks() {
    return stockRepository.findAll();
  }

  @Override
  public Stock findStockById(Long id) {
    return stockRepository.findById(id).orElse(null);
  }

  @Override
  public List<StockDto> findStockDtos() {
    List<Stock> stocks = stockRepository.findAll();
    if (stocks.size() == 0) {
      throw new RecordNotFoundException(); // RuntimeException
    }

    List<StockDto> stockDtos = new ArrayList<>();
    stocks.forEach(e -> {
      StockDto stockDto = StockDto.builder()
          .productCode(e.getProductCode())
          .stockId(e.getStockId())
          .build();
      stockDtos.add(stockDto);
    });
    return stockDtos;
  }

}
