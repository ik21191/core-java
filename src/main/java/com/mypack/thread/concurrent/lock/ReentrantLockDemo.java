package com.mypack.thread.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

class SharedObject1 {
	private static final Logger log = Logger.getLogger(SharedObject1.class);
	ReentrantLock lock = new ReentrantLock();
	
	public void read1() {
		//below statement is executed before the lock so both thread can access this concurrenly
		log.info("read()1: Thread Name: " + Thread.currentThread().getName() + ": reading start..");
		log.info("read()1: Thread Name: " + Thread.currentThread().getName() + ": is hold by other thread: " + lock.getHoldCount());
		
		lock.lock();
		
		log.info("read()1: Thread Name: " + Thread.currentThread().getName() + ": got the lock");
		try {
			for (int i = 1; i <= 5; i++) {
				log.info("read()1: Thread Name: " + Thread.currentThread().getName() + ": Reading: " + i);
				Thread.sleep(500);
			}
			read2();//Here the lock is spawned to this method, that is why it is called Reentrant in nature

		} catch (InterruptedException e) {
			log.error(e);
		} finally {
			lock.unlock();
		}
		log.info("read1(): reading end.");
	}
	
	public void read2() {
		//below statement is executed before the lock so both thread can access this concurrenly
		log.info("read()2: Thread Name: " + Thread.currentThread().getName() + ": reading start..");
		log.info("read()2: Thread Name: " + Thread.currentThread().getName() + ": is hold by other thread: " + lock.getHoldCount());
		
		lock.lock();
		
		log.info("read()2: Thread Name: " + Thread.currentThread().getName() + ": got the lock");
		try {
			for (int i = 6; i <= 10; i++) {
				log.info("read()2: Thread Name: " + Thread.currentThread().getName() + ": Reading: " + i);
				Thread.sleep(500);
			}

		} catch (InterruptedException e) {
			log.error(e);
		} finally {
			lock.unlock();
		}
		log.info("read2(): reading end.");
	}
}

class ReaderThread implements Runnable {
	private SharedObject1 sharedObject1;

	public ReaderThread(SharedObject1 sharedObject1) {
		this.sharedObject1 = sharedObject1;
	}

	@Override
	public void run() {
		sharedObject1.read1();
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
