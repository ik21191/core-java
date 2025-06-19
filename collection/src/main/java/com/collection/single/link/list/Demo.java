package com.collection.single.link.list;

public class Demo {
  public static void main(String[] args) {
    MyLinkedList myLinkedlist = new MyLinkedList();
    myLinkedlist.add(1);
    myLinkedlist.add(2);
    myLinkedlist.add(3);
    myLinkedlist.add(3);
    myLinkedlist.add(2);
    myLinkedlist.add(1);
    System.out.println(myLinkedlist);
    System.out.println(myLinkedlist.size());
  }
}
