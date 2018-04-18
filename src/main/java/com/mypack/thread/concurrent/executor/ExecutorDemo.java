package com.mypack.thread.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SharedResource {
	public synchronized void print() {
		for(int i= 1; i <= 5; i++) {
			System.out.println("executing: " + Thread.currentThread().getName() + "  counter: " + i);
			try {
				Thread.sleep(2000);
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

	public static void main(String[] args) {
		SharedResource sharedResource = new SharedResource();
		Task t1 = new Task(sharedResource);
		Task t2 = new Task(sharedResource);
		Task t3 = new Task(sharedResource);
		Task t4 = new Task(sharedResource);
		Task t5 = new Task(sharedResource);
		
		/*Thread t1 = new Thread(new Task(sharedResource), "Thread1");
		Thread t2 = new Thread(new Task(sharedResource), "Thread2");
		Thread t3 = new Thread(new Task(sharedResource), "Thread3");
		Thread t4 = new Thread(new Task(sharedResource), "Thread4");
		Thread t5 = new Thread(new Task(sharedResource), "Thread5");*/
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(t1);
		executorService.execute(t2);
		executorService.execute(t3);
		executorService.execute(t4);
		executorService.execute(t5);
		
		executorService.shutdown();

	}

}
