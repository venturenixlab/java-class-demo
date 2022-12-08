package com.vtxlab.demo.openweather.response;

import java.time.LocalDateTime;

import javax.print.attribute.standard.DateTimeAtCompleted;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {

  String teamCode;

  LocalDateTime dateTime;

}
