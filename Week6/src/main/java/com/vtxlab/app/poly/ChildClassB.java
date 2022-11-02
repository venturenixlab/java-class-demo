package com.vtxlab.app.poly;

public class ChildClassB extends ParentClass {

  @Override
  public void doSomething() {
    System.out.println("i am a child B");
  }

  public String getChildName() {
    return "Tommy";
  }
}
