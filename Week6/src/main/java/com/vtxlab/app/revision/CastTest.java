package com.vtxlab.app.revision;

public class CastTest {
  public static void main(String[] args) {
    Number number = (byte) 1; // 1 = Integer
    Integer i = (Integer) number; // runtime exception

    
  }
}
