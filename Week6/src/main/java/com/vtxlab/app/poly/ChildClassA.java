package com.vtxlab.app.poly;

public class ChildClassA extends ParentClass {

  @Override
  public void doSomething() {
    System.out.println("i am a child A");
  }

  public static void main(String[] args) {
    ParentClass o1 = new ParentClass();
    ParentClass o2 = new ChildClassA();
    ParentClass o3 = new ChildClassB();

    o1.doSomething();
    o2.doSomething();
    o3.doSomething();

    // ChildClassB2 child = (ChildClassB2) o3; // hit java.lang.ClassCastException
    // ChildClassA child2 = (ChildClassA) o3; // another child
    ChildClassB child = (ChildClassB) o3;
    System.out.println(child.getChildName());

    ParentClass parent = (ChildClassB) o3; // ??
    parent.doSomething();
  }
}
