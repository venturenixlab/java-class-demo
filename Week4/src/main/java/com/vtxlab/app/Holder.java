package com.vtxlab.app;

public class Holder<T> {
  private T t;

  public T getT() {
    return this.t;
  }

  public void setT(T t) {
    this.t = t;
  }

  public static <T> Holder<T> getHolder(T t) {
    Holder<T> intHolder = new Holder<>();
    intHolder.setT(t);
    return intHolder;
  }
}
