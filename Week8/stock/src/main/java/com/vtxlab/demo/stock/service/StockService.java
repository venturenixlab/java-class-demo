package com.vtxlab.demo.stock.service;

import java.util.List;

import com.vtxlab.demo.stock.entity.Stock;
import com.vtxlab.demo.stock.model.StockDto;

public interface StockService {

  List<Stock> findStocks();

  Stock findStockById(Long id);

  List<StockDto> findStockDtos();

}
