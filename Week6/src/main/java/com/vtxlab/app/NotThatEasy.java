package com.vtxlab.app;

import java.util.ArrayList;
import java.util.List;

public class NotThatEasy {

  static final List<Character> characters;
  private static final char[] chars = { 'J', 'a', 'c', 'k', 'y' };
  int a = 0;

  static {
    characters = new ArrayList<>();
  }

  {
    System.out.println("initilization block");
    characters.add('V');
  }

  public static void main(String[] args) {
    NotThatEasy e = new NotThatEasy();
    for (char c : chars) {
      characters.add(c);
    }
    System.out.println(characters.size());
    

  }
}
