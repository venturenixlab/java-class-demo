package com.vtxlab.app;

public record Person(String name, String address) {

  public String getName() {
    return this.name;
  }

}
