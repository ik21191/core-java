package com.mypack.thread.util.concurrent;

import java.util.concurrent.Semaphore;

class MySharedResource {
	public static int count = 0;
}
class SemaphoreThread implements Runnable {
	private Semaphore semaphore = null;
	
	public SemaphoreThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " waiting for the permission.");
			Thread.sleep(3000);
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " got the permission.");
			Thread.sleep(3000);
			if(MySharedResource.count > 0) {
				for(int i = 0; i < 5; i++) {
					MySharedResource.count--;
					System.out.println(Thread.currentThread().getName() + " " + MySharedResource.count);
					Thread.sleep(2000);
				}
			} else {
				for(int i = 0; i < 5; i++) {
					MySharedResource.count++;
					System.out.println(Thread.currentThread().getName() + " " + MySharedResource.count);
					Thread.sleep(2000);
				}
			}
			System.out.println(Thread.currentThread().getName() + " count value is : " + MySharedResource.count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + " releasing permission...");
			semaphore.release();
		}
		
	}
}
public class SemaphoreDemo {

	public static void main(String[] args) throws InterruptedException {
		
		Semaphore semaphore = new Semaphore(2, true);
		Thread t1 = new Thread(new SemaphoreThread(semaphore), "Thread 1");
		Thread t2 = new Thread(new SemaphoreThread(semaphore), "Thread 2");
		Thread t3 = new Thread(new SemaphoreThread(semaphore), "Thread 3");
		Thread t4 = new Thread(new SemaphoreThread(semaphore), "Thread 4");
		Thread t5 = new Thread(new SemaphoreThread(semaphore), "Thread 5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		System.out.println(Thread.currentThread().getName() +  "   " + MySharedResource.count);
	}

}
