package com.vtxlab.demo.stock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockDto { // data transfer object

  private String stockId;

  private String productCode;

}
