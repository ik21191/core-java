package com.mypack.thread.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class SharedResource {
  public synchronized void print() {
    for (int i = 1; i <= 5; i++) {
      System.out.println("executing: " + Thread.currentThread().getName() + "  counter: " + i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
  }
}


class Task implements Runnable {
  private SharedResource sharedResource;

  public Task(SharedResource sharedResource) {
    this.sharedResource = sharedResource;
  }


  @Override
  public void run() {
    sharedResource.print();
  }
}


public class ExecutorDemo {

  public static void main(String[] args) throws Exception {
    SharedResource sharedResource = new SharedResource();
    Task t1 = new Task(sharedResource);
    Task t2 = new Task(sharedResource);
    Task t3 = new Task(sharedResource);
    Task t4 = new Task(sharedResource);
    Task t5 = new Task(sharedResource);

    /**
    Thread t1 = new Thread(new Task(sharedResource), "Thread1");
    Thread t2 = new Thread(new Task(sharedResource), "Thread2");
    Thread t3 = new Thread(new Task(sharedResource), "Thread3");
    Thread t4 = new Thread(new Task(sharedResource), "Thread4");
    Thread t5 = new Thread(new Task(sharedResource), "Thread5");
    */
    
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    
    /*executorService.execute(t1);
    executorService.execute(t2);
    executorService.execute(t3);
    executorService.execute(t4);
    System.out.println("future value: " + executorService.submit(t5).get());
    
    executorService.shutdown();*/
    
    /*executorService = Executors.newCachedThreadPool();
    executorService.execute(t1);
    executorService.execute(t2);
    executorService.execute(t3);
    executorService.execute(t4);
    
    System.out.println("future value: " + executorService.submit(t5).get());
    
    //executorService.shutdown();
    */

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
    System.out.println("After 3 seconds thread will start.");
    // scheduledExecutorService.schedule(t1, 3, TimeUnit.SECONDS);

    ScheduledFuture<?> future =
        scheduledExecutorService.scheduleAtFixedRate(t1, 3, 3, TimeUnit.SECONDS);
    int count = 0;
    while (true) {
      count++;
      Thread.sleep(10000);
      if (count == 3) {
        future.cancel(true);
        scheduledExecutorService.shutdown();
        break;
      }
    }
  }
}
