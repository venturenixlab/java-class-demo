package com.vtxlab.app.revision;

import java.util.List;

public class NumberHolder<T extends Number> {
  List<T> list;

  public NumberHolder setList(List<T> t) {
    this.list = t;
    return this;
  }

}
