package com.mypack.thread.concurrent.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class FutureDemo2 {
	private static int counter = 0;

	public static void main(String[] args) throws Exception {
		Callable<Integer> callable = ()-> {
			System.out.println("call() method is called.");
			Thread.sleep(5000);
			return ++counter;
		};
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Integer> future = service.submit(callable);
		//future.get();
		service.shutdown();
		/*
		 * while(!future.isDone()) { System.out.println("Task not completed");
		 * //System.out.println(future.get()); }
		 */
		System.out.println("Task completed.");
	}

}
