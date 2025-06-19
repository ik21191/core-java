package com.mypack.thread.concurrent.executor;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureUsingSupplyAsync {
  
  public static void main(String[] args) throws Exception {
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
      System.out.println(Thread.currentThread().getName());
      // Simulate a long-running task
      try {
          Thread.sleep(3000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      return "Hello";
  });

  CompletableFuture<String> transformedFuture = future.thenApplyAsync(s -> {
    System.out.println(Thread.currentThread().getName());
    return s + " World";
  });

  transformedFuture.thenAccept(result -> System.out.println(Thread.currentThread().getName() + " Result: " + result));
  transformedFuture.join();
  //System.out.println(Thread.currentThread().getName() + "  " + transformedFuture.get());

  // The main thread doesn't block while the asynchronous tasks are running.
  }

}
