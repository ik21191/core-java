package com.mypack.thread.concurrent.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {

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
		        System.out.println("I'll run in a separate thread than the main thread.");
		    }
		});

		// Block and wait for the future to complete
		future.get();
		
		System.out.println("Done");

	}

}
