package com.mypack.thread.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

class InterruptThread implements Runnable {
	private static final Logger log = Logger.getLogger(InterruptThread.class);
	Lock lock;
	boolean intruptFlag;
	
	public InterruptThread(Lock lock, boolean intruptFlag) {
		this.lock = lock;
		this.intruptFlag = intruptFlag;
	}

	@Override
	public void run() {
		try {
			if(intruptFlag) {
				lock.lockInterruptibly();
			} else {
				lock.lock();
			}
		}
		catch(InterruptedException e) {
			log.error(e);
		}
		try {
			for(int i = 1; i <= 5; i++) {
				log.info("Thread Name: " + Thread.currentThread().getName() + ": Reading: " + i);
				Thread.sleep(1000);
			}
		} catch(Exception e) {
			log.error(e);
		} finally {
			lock.unlock();
		}
	}
}

public class IntruptlyDemo {
	public static void main(String arr[]) {
		Lock lock = new ReentrantLock();
		Thread t1 = new Thread(new InterruptThread(lock, true), "ReadThread1");
		Thread t2 = new Thread(new InterruptThread(lock, true), "ReadThread2");
		Thread t3 = new Thread(new InterruptThread(lock, true), "ReadThread3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
