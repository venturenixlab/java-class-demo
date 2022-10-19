package com.vtxlab.model;

import com.vtxlab.interfaces.MathOperation;

public class MathOperationHolder implements MathOperation {

  @Override
  public int compute(int x, int y) {
    return x + y;
  }

}
