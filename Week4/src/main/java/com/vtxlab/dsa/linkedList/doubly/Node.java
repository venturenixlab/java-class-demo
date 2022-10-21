package com.vtxlab.dsa.linkedList.doubly;

public class Node {
  private Node prev;
  private int data;
  private Node next;

  private Node(int d) {
    prev = null;
    data = d;
    next = null;
  }

  public Node getPrev() {
    return this.prev;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }

  public int getData() {
    return this.data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public Node getNext() {
    return this.next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}
