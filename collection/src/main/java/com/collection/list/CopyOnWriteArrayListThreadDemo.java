package com.collection.list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class ReaderThread implements Runnable {
  CopyOnWriteArrayList<String> list;
  
  public ReaderThread(CopyOnWriteArrayList<String> list) {
    this.list = list;
  }
  @Override
  public void run() {
    Iterator<String> iterator = list.iterator();
    //The iterator will not display latest value "5" because the iterator was created before updating the list
    while (iterator.hasNext()) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(iterator.next());
    }
  }
}

public class CopyOnWriteArrayListThreadDemo {
  
  public static void main(String[] args) throws Exception {
    CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
    list.add(null); //null values are allowed
    list.add(null);
    list.add("2");
    list.add("3");
    list.add("4");
    
    Thread reader = new Thread(new ReaderThread(list), "Reader");
    reader.start();
    Thread.sleep(1000);
    System.out.println("Adding 5");
    list.add("5");
    System.out.println("Added 5");
  }
}
