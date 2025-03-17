package com.mypack.thread.misc;

import java.util.concurrent.ThreadFactory;

class MyThreadFactory implements ThreadFactory {
  int count = 0;

  @Override
  public Thread newThread(Runnable r) {
    return new Thread(r, "test-" + ++count);
  }
}


public class ThreadFactoryDemo {

  public static void main(String[] args) {

    Runnable runnable = () -> {
      System.out.println("Executing " + Thread.currentThread().getName());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    MyThreadFactory myThreadFactory = new MyThreadFactory();
    Thread thread1 = myThreadFactory.newThread(runnable);
    thread1.start();

    Thread thread2 = myThreadFactory.newThread(runnable);
    thread2.start();
  }

}
