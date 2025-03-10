package com.mypack.thread;

public class App {
  public static void main(String[] args) throws InterruptedException {
 
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("runnin thread");
      }
    };
    Thread t1 = new Thread(runnable, "t1");
    t1.start();
    System.out.println("running main thread");
    t1.join();
    System.out.println("Main thread completed.");
  }
}
