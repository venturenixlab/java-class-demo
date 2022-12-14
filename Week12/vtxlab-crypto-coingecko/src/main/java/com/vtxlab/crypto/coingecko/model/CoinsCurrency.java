package com.vtxlab.crypto.coingecko.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinsCurrency implements Serializable {
  
  //@JsonProperty("usd")
  private BigDecimal usd;

  //@JsonProperty("hkd")
  private BigDecimal hkd;

}
