package com.mypack.thread.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

class SharedObject2 {
	private static final Logger log = Logger.getLogger(SharedObject2.class);
	public void read() {
		//below statement is executed before the lock so both thread can access this concurrenly
		log.info("read(): Thread Name: " + Thread.currentThread().getName() + ": reading start..");
		
		log.info("read(): Thread Name: " + Thread.currentThread().getName() + ": got the lock");
		try {
			for (int i = 1; i <= 5; i++) {
				log.info("read(): Thread Name: " + Thread.currentThread().getName() + ": Reading: " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			log.error(e);
		} 
		log.info("reading end.");
	}
}

class TryLockThread implements Runnable {
	private static final Logger log = Logger.getLogger(TryLockThread.class);
	private Lock lock;
	private SharedObject2 sharedObject2;

	public TryLockThread(SharedObject2 sharedObject2, Lock lock) {
		this.sharedObject2 = sharedObject2;
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			if(lock.tryLock(10, TimeUnit.SECONDS)/*lock.tryLock()*/) {
				try {
					sharedObject2.read();
				} finally {
					lock.unlock();
				}
			} else {
				log.info("run(): Thread Name: " + Thread.currentThread().getName() + ": lock is acquired by other thread so executing else block");
			}
		}
		catch(Exception e) {
			log.error(e);
		} 
	}
}

public class TryLockDemo {
	public static void main(String arr[]) {
		SharedObject2 sharedObject2 = new SharedObject2();
		Lock lock = new ReentrantLock();
		Thread t1 = new Thread(new TryLockThread(sharedObject2, lock), "ReadThread1");
		Thread t2 = new Thread(new TryLockThread(sharedObject2, lock), "ReadThread2");
		Thread t3 = new Thread(new TryLockThread(sharedObject2, lock), "ReadThread3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
