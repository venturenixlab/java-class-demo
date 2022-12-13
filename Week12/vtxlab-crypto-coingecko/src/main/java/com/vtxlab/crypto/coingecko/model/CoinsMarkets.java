package com.vtxlab.crypto.coingecko.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinsMarkets implements Serializable {
  private String id;
  private String symbol;
  private String name;
  private String image;
  private BigDecimal currentPrice;
  private BigDecimal marketCap;
  private BigDecimal marketCapRank;
  private BigDecimal fullyDilutedValuation;
  private BigDecimal totalVolume;
  @JsonProperty(value = "high_24h")
  private BigDecimal high24h;
  @JsonProperty(value = "low_24h")
  private BigDecimal low24h;
  @JsonProperty(value = "price_change_24h")
  private BigDecimal priceChange24h;
  @JsonProperty(value = "price_change_percentage_24h")
  private BigDecimal priceChangePercentage24h;
  @JsonProperty(value = "market_cap_change_24h")
  private BigDecimal marketCapChange24h;
  @JsonProperty(value = "market_cap_change_percentage_24h")
  private BigDecimal marketCapChangePercentage24h;
  private BigDecimal circulatingSupply;
  private BigDecimal totalSupply;
  private BigDecimal maxSupply;
  private BigDecimal ath;
  private BigDecimal ath_change_percentage;
  private LocalDateTime ath_date;
  private Roi roi;
  private LocalDateTime lastUpdated;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public class Roi {
    private BigDecimal times;
    private String currency;
    private BigDecimal percentage;
  }

}
