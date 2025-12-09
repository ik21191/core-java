package com.mypack.thread.concurrent.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureUsingRunAsync {

	public static void main(String[] args) throws Exception {
		
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
		    @Override
		    public void run() {
		        // Simulate a long-running Job
		        try {
		            TimeUnit.SECONDS.sleep(3);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        System.out.println(Thread.currentThread().getName() + " I'll run in a separate thread than the main thread.");
		    }
		});
		
		future.thenRunAsync(()->System.out.println("Executed using thenRunAsync()"));

		// Block and wait for the future to complete
		future.get();
		
		System.out.println(Thread.currentThread().getName() + " Done");

	}

}
