package com.mypack.thread.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

class MyCallable implements Callable<Integer> {
	
	@Override
	public Integer call() throws Exception {
		Thread.sleep(3000);
		int result = new Random().nextInt(1000);
		System.out.println("Random number is : " + result);
		return result;
	}
}

public class CallableFutureDemo {
	private static final Logger log = Logger.getLogger(CallableFutureDemo.class);
	public static void main(String[] args) throws Exception {
		MyCallable c1 = new MyCallable();
		MyCallable c2 = new MyCallable();
		MyCallable c3 = new MyCallable();
		MyCallable c4 = new MyCallable();
		MyCallable c5 = new MyCallable();
		
		List<Future<Integer>> futureList = new ArrayList<>();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		futureList.add(executorService.submit(c1));
		futureList.add(executorService.submit(c2));
		futureList.add(executorService.submit(c3));
		futureList.add(executorService.submit(c4));
		futureList.add(executorService.submit(c5));
		
		executorService.shutdown();

		log.info("Displaying result of Callable using Future: ");
		
		for(Future<Integer> future : futureList) {
			log.info(future.get());
			Thread.sleep(3000);
		}
	}
}
