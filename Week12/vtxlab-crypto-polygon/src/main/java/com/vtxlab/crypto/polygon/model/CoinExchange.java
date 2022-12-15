package com.vtxlab.crypto.polygon.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinExchange implements Serializable {

  @JsonProperty(value = "request_id")
  String requestId;

  BigDecimal count;
  String status;
  String ticker;
  BigDecimal queryCount;
  BigDecimal resultCount;
  Boolean adjusted;
  @JsonProperty(value = "results")
  List<ExchangeResult> exchangeResults;

  public String getTickerCryptoString() {
    return this.ticker.substring(2, 5); // X:BTCUSD -> BTC
  }

  public String getTickerCurrencyString() {
    return this.ticker.substring(5, 8); // X:BTCUSD -> USD
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class ExchangeResult implements Serializable {
    @JsonProperty(value = "T")
    String ticker;
    @JsonProperty(value = "c")
    BigDecimal closePrice;
    @JsonProperty(value = "h")
    BigDecimal highestPrice;
    @JsonProperty(value = "l")
    BigDecimal lowestPrice;
    @JsonProperty(value = "n")
    BigDecimal noOfTran;
    @JsonProperty(value = "o")
    BigDecimal openPrice;
    @JsonProperty(value = "t")
    BigDecimal startTimestamp;
    @JsonProperty(value = "v")
    BigDecimal tradeVolume;
    @JsonProperty(value = "vw")
    BigDecimal volumeWeightedAveragePrice;
  }

}
