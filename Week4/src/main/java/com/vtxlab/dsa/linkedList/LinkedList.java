package com.vtxlab.dsa.linkedList;

import java.util.Vector;

import com.vtxlab.dsa.linkedList.singly.Node;

public class LinkedList {
  Node head;

  public LinkedList push(int newData) { // return self
    Node node = new Node(newData);
    node.setNext(head);
    this.head = node;
    return this; // add one more line
  }

  public Node peek() {
    return this.head;
  }

  public LinkedList deleteNode(int key) { // delete a specific int
    // Store head node
    Node temp = head;
    Node prev = null;
    Vector

    // If first node data == key, early return. Reduce Complexity.
    // O(1)
    if (temp != null && temp.getData() == key) {
      head = temp.getNext(); // Changed head
      return this;
    }
    // O(n)
    while (temp != null && temp.getData() != key) {
      prev = temp;
      temp = temp.getNext();
    }
    // If key was not present in linked list
    if (temp == null) {
      return this;
    }
    // Unlink the node from linked list
    prev.setNext(temp.getNext());

    return this;
  }

  public void print() {
    Node tnode = head;
    while (tnode != null) { // search until tnode = null
      System.out.print(tnode.getData() + " ");
      System.out.print("The data is odd: " + tnode.isNodeDataOdd()); //
      tnode = tnode.getNext();
    }
  }

  public static void print(LinkedList ll) {
    Node tnode = ll.head;
    while (tnode != null) { // search until tnode = null
      System.out.print(tnode.getData() + " ");

      tnode = tnode.getNext();
    }
  }

  public static void main(String[] args) {
    // Create a singly linkedList
    LinkedList linkedList = new LinkedList();
    linkedList.push(5);
    linkedList.push(100);
    linkedList.push(30).push(20).push(200).deleteNode(100).push(40).print();

    System.out.println("");
    LinkedList.print(linkedList);

    System.out.println("");
    System.out.println(linkedList.head.getNext().getNext().getData());

  }
}
