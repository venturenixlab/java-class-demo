package com.vtxlab.demo.openweather.model.currentweather;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloudIndex {
  
  /**
   * Cloudiness %
   */
  @JsonProperty("all")
  private BigDecimal cloudinessPercent;

  

}
