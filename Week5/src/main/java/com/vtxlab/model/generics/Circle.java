package com.vtxlab.model.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Circle extends Shape implements Area {

  public int radius;

  @Override
  public double area() {
    return this.radius * this.radius * 3.14;
  }

  // @Override
  // public double calculate() {
  // return area();
  // }

}
