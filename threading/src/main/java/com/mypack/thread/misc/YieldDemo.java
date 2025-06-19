package com.mypack.thread.misc;

public class YieldDemo {

  public static void main(String[] args) throws Exception {
  
    Runnable runnable = () -> {
      synchronized (YieldDemo.class) {
        System.out.println("Executing inside synchronized block........");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
        
        }
        Thread.yield();
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
        
        }
        System.out.println("Executing inside synchronized block resumed........");
      }
      };
    Thread thread = new Thread(runnable, "t1");
    thread.start();
    Thread.sleep(1000);
    System.out.println("Main completed.");
  }

}
