package com.vtxlab.app.generics;

public class Box<T> {
  // T stands for "Type", naming convention only.
  // You can use other Character, such as S.
  private T t;

  public void set(T t) {
    this.t = t;
  }

  public T get() {
    return t;
  }

  public static <T> Box<T> createBox(T value) {
    Box<T> box = new Box<>();
    box.set(value);
    return box;
  }

  public static void main(String[] args) {
    Box<String> stringbox = createBox("I am Vincent");
    
  }
}