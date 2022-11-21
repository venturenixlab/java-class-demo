package com.vtxlab.demo.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Stocks")
public class Stock {
  
  @Id // primary key
  private Long id; // 4

  @Column(name = "STOCK_ID")
  private String stockId; // ITEM0000001

  @Column(name = "PRODUCT_CODE")
  private String productCode;

  private Double weight;

}
