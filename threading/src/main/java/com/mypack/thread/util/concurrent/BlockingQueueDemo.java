package com.mypack.thread.util.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerBlockingQueue implements Runnable {
  private BlockingQueue<String> blockingQueue;

  public ProducerBlockingQueue(BlockingQueue<String> blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  @Override
  public void run() {
    try {
      String name = "Imran Khan";
      System.out.println(Thread.currentThread().getName() + " inserting " + name);
      blockingQueue.put(name);
      
      Thread.sleep(3000);
      name = "Vijay Kumar";
      System.out.println(Thread.currentThread().getName() + " inserting " + name);
      blockingQueue.put(name);
      
      Thread.sleep(3000);
      name = "Rahul Verma";
      System.out.println(Thread.currentThread().getName() + " inserting " + name);
      blockingQueue.put(name);
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class ConsumerBlockingQueue implements Runnable {
  private BlockingQueue<String> blockingQueue;

  public ConsumerBlockingQueue(BlockingQueue<String> blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  @Override
  public void run() {
    try {
      System.out
          .println(Thread.currentThread().getName() + " " + blockingQueue.take() + " fetched.");
      Thread.sleep(3000);
      
      System.out
          .println(Thread.currentThread().getName() + " " + blockingQueue.take() + " fetched.");
      Thread.sleep(3000);
      
      System.out
          .println(Thread.currentThread().getName() + " " + blockingQueue.take() + " fetched.");
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

public class BlockingQueueDemo {

  public static void main(String[] args) {
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
    Thread producer = new Thread(new ProducerBlockingQueue(blockingQueue), "Producer");
    Thread consumer = new Thread(new ConsumerBlockingQueue(blockingQueue), "Consumer");

    producer.start();
    consumer.start();
  }
}
