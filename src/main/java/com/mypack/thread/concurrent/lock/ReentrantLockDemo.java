package com.mypack.thread.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

class SharedObject1 {
	ReentrantLock lock = new ReentrantLock();
	
	public void read() {
		//below statement is executed before the lock so both thread can access this concurrenly
		System.out.println("read(): Thread Name: " + Thread.currentThread().getName() + ": reading start..");
		System.out.println("read(): Thread Name: " + Thread.currentThread().getName() + ": is hold by other thread: " + lock.isHeldByCurrentThread());
		
		lock.lock();
		
		System.out.println("read(): Thread Name: " + Thread.currentThread().getName() + ": got the lock");
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println("read(): Thread Name: " + Thread.currentThread().getName() + ": Reading: " + i);
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			System.out.println(e);
		} finally {
			lock.unlock();
		}
		System.out.println("reading end.");
	}
}

class ReaderThread implements Runnable {
	private SharedObject1 sharedObject1;

	public ReaderThread(SharedObject1 sharedObject1) {
		this.sharedObject1 = sharedObject1;
	}

	@Override
	public void run() {
		sharedObject1.read();
	}
}

public class ReentrantLockDemo {
	public static void main(String arr[]) {
		SharedObject1 sharedObject1 = new SharedObject1();
		Thread t1 = new Thread(new ReaderThread(sharedObject1), "ReadThread1");
		Thread t2 = new Thread(new ReaderThread(sharedObject1), "ReadThread2");
		Thread t3 = new Thread(new ReaderThread(sharedObject1), "ReadThread3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
