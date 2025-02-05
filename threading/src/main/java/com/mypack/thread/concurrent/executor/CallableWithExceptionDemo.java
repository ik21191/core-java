package com.mypack.thread.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

class MyCallable1 implements Callable<Integer> {
	
	private String number;
	
	public MyCallable1(String number) {
		this.number = number;
	}
	
	@Override
	public Integer call() throws NumberFormatException, InterruptedException {
		Thread.sleep(3000);
		int i = Integer.parseInt(number); 
		System.out.println("i :  " + i);
		return i;
	}
}

public class CallableWithExceptionDemo {
	private static final Logger log = Logger.getLogger(CallableWithExceptionDemo.class);
	public static void main(String[] args) throws Exception {
		MyCallable1 c1 = new MyCallable1("1");
		MyCallable1 c2 = new MyCallable1("Imran");
		MyCallable1 c3 = new MyCallable1("Imran");
		MyCallable1 c4 = new MyCallable1("2");
		MyCallable1 c5 = new MyCallable1("3");
		
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
			try {
				/**
				 * If we don't make the call to the get() method of Future class – then the exception thrown by call() method will not be reported back,
				 *  and the task will still be marked as completed*/
				int result = future.get();
				System.out.println(result);
				Thread.sleep(3000);
			} catch (ExecutionException ex) {
				System.out.println("ExecutionException : " + ex.getCause());
			} catch (Exception e) {
				System.out.println("Exception : " + e);
			}
		}
	}
}
