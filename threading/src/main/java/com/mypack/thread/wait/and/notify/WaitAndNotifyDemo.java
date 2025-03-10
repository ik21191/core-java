package com.mypack.thread.wait.and.notify;

import java.util.Scanner;

class Data {
  public void produce() throws Exception {
    synchronized (this) {
      System.out.println(Thread.currentThread().getName() + "   started.");
      for (int i = 1; i <= 5; i++) {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "   " + i);
      }
      System.out.println(Thread.currentThread().getName() + "   completed my work.");
      System.out.println(Thread.currentThread().getName() + "   going to wait state....");
      wait();
      System.out.println(Thread.currentThread().getName() + "   woke up.");
    }
  }

  public void consume() throws Exception {
    Scanner scanner = new Scanner(System.in);
    synchronized (this) {
      System.out.println(Thread.currentThread().getName() + "   started.");
      Thread.sleep(2000);
      for (int i = 5; i <= 10; i++) {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "   " + i);
      }
      System.out.println(Thread.currentThread().getName() + "   completed my work.");
      System.out.println("Press enter key to continue......");
      scanner.nextLine();
      scanner.close();
      System.out.println("Notifying....");
      notify();
    }
  }
}


public class WaitAndNotifyDemo {

  public static void main(String[] args) {
    final Data data = new Data();

    Thread producer = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          data.produce();
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }, "Producer Thread");

    Thread consumer = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          data.consume();
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }, "Consumer Thread");
    producer.start();
    consumer.start();

    // ExecutorService executorService = Executors.newFixedThreadPool(2);
    // executorService.execute(producer);
    // executorService.execute(consumer);
  }
}
