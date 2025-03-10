package com.mypack.thread.wait.and.notify;

public class ThreadA {
  public static void main(String[] args) {
    ThreadB b = new ThreadB();
    b.start();

    synchronized (b) {
      try {
        System.out.println("Waiting for b to complete...");
        b.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("Total is: " + b.total);
    }
  }
}


class ThreadB extends Thread {
  int total;

  @Override
  public void run() {
    synchronized (this) {

      for (int i = 0; i < 5; i++) {
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        total += i;
      }
      notify();
    }
  }
}


/*
public class ThreadA {
  public static void main(String[] args) {
    ThreadB b = new ThreadB();
    b.start();

    System.out.println("Total is: " + b.total);

  }
}


class ThreadB extends Thread {
  int total;

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      total += i;
    }
  }
}
*/