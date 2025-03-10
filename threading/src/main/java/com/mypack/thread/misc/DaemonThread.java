package com.mypack.thread.misc;

public class DaemonThread {

  public static void main(String[] args) {
  
    Runnable runnable = () -> System.out.println("This is thread");
    Thread thread = new Thread(runnable, "t1");
    
    thread.setDaemon(true);
    thread.start();
    System.out.println("Main completed.");
  }

}
