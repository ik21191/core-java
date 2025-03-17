package com.mypack.thread1;

public class JoinDemo {

  public static void main(String[] args) throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " thread started.");
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        for (int i = 1; i <= 5; i++) {
          System.out.println(Thread.currentThread().getName() + " : " + i);
          try {
          Thread.sleep(2000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(Thread.currentThread().getName() + " ended.");
      }
    };
    Thread t1 = new Thread(runnable, "t1");
    t1.start();
    // starts second thread when first thread t1 is died.
    t1.join();

    Thread t2 = new Thread(runnable, "t2");
    t2.start();
    t2.join();
    t1.join();

    System.out.println(Thread.currentThread().getName() + " resumed.");
  }

}
