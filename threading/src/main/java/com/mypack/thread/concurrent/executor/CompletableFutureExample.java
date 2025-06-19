package com.mypack.thread.concurrent.executor;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
  
  private static CompletableFuture<String> getCompletableFuture() throws Exception {
    System.out.println("Sleeping for 5 seconds");
    Thread.sleep(5000);
    return CompletableFuture.completedFuture("Future Completed");
  }

  public static void main(String[] args) throws Exception {
    CompletableFuture<String> future = getCompletableFuture();
    System.out.println("Resuming main method.");
    //System.out.println(future.get());
  }

}
