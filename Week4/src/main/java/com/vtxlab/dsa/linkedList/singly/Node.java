package com.vtxlab.dsa.linkedList.singly;

public class Node {
  private int data;
  private Node next;

  public Node(int d) {
    data = d;
    next = null;
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

  public boolean isNodeDataOdd() {
    return this.data % 2 == 1;
  }
}
