package com.mypack.thread.util.concurrent;

import java.util.concurrent.CountDownLatch;

class ServiceThread implements Runnable {
	private CountDownLatch countDownLatch;
	private int waitTime;
	
	public ServiceThread(CountDownLatch countDownLatch, int waitTime) {
		this.countDownLatch = countDownLatch;
		this.waitTime = waitTime;
	}
	
	@Override
	public void run() {
		
		synchronized(this) {
			try {
				Thread.sleep(waitTime);
				System.out.println(Thread.currentThread().getName() + " up.");
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class CounDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch countDownLatch = new CountDownLatch(3);
		Thread t1 = new Thread(new ServiceThread(countDownLatch, 3000), "Email Service");
		Thread t2 = new Thread(new ServiceThread(countDownLatch, 3000), "SMS Service");
		Thread t3 = new Thread(new ServiceThread(countDownLatch, 3000), "Validation Service");
		t1.start();
		t2.start();
		t3.start();
		
		/*Waiting other thread to complete*/
		countDownLatch.await();
		System.out.println("All services are up, starting main application.");
		
	}

}
