package com.mypack.thread.wait.and.notify;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

class Producer implements Runnable {
  private static final Logger log = Logger.getLogger(Producer.class);

  private final List<Integer> taskQueue;
  private final int MAX_CAPACITY;

  public Producer(List<Integer> sharedQueue, int size) {
    this.taskQueue = sharedQueue;
    this.MAX_CAPACITY = size;
  }

  @Override
  public void run() {
    int counter = 0;
    while (true) {
      try {
        /*
         * If we uncomment below code then producer will produce one element and then consumer will
         * consume that element, means the operation will be like adding and element and deleting
         * element
         */
        // Thread.sleep(1000);
        produce(counter++);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }

  private void produce(int i) throws InterruptedException {
    synchronized (taskQueue) {
      while (taskQueue.size() == MAX_CAPACITY) {
        log.info("Queue is full " + Thread.currentThread().getName() + " is waiting , size: "
            + taskQueue.size());
        taskQueue.wait();
        System.out.println("Producer woke up.");
      }

      Thread.sleep(1000);
      taskQueue.add(i);
      log.info("Produced: " + i);
      /*
       * Since we have only one Producer and one Consumer then notify() will works fine if we have
       * multiple producer and consumer then we need to call notifyAll()
       */
      taskQueue.notify();
      // taskQueue.notifyAll();
    }
  }
}


class Consumer implements Runnable {
  private static final Logger log = Logger.getLogger(Consumer.class);
  private final List<Integer> taskQueue;

  public Consumer(List<Integer> sharedQueue) {
    this.taskQueue = sharedQueue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        consume();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }

  private void consume() throws InterruptedException {
    synchronized (taskQueue) {
      while (taskQueue.isEmpty()) {
        log.info("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: "
            + taskQueue.size());
        taskQueue.wait();
        System.out.println("Consumer woke up.");
      }
      Thread.sleep(1000);
      int i = (Integer) taskQueue.remove(0);
      log.info("Consumed: " + i);
      /*
       * Since we have only one Producer and one Consumer then notify() will works fine if we have
       * multiple producer and consumer then we need to call notifyAll()
       */
      taskQueue.notify();
      // taskQueue.notifyAll();
    }
  }
}

public class ProducerConsumer {
  public static void main(String[] args) {
    List<Integer> taskQueue = new ArrayList<Integer>();
    int MAX_CAPACITY = 5;
    Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
    Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
    tProducer.start();
    tConsumer.start();
  }
}
