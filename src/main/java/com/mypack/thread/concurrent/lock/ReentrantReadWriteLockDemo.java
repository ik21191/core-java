package com.mypack.thread.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.Logger;

class SharedObject {
	private static final Logger log = Logger.getLogger(SharedObject.class);
	private ReadWriteLock rwLock = new ReentrantReadWriteLock();
	private Lock readLock = rwLock.readLock();
	private Lock writeLock = rwLock.writeLock();
	
	public void read() {
		readLock.lock();
		log.info("reading start..");
		try {
			for (int i = 1; i <= 5; i++) {
				log.info("read(): Thread Name: " + Thread.currentThread().getName() + "  Reading: " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			log.error(e);
		} finally {
			readLock.unlock();
		}
		log.info("reading end.");
	}
	

	public void write() {
		log.info("Writing startd ..");
		writeLock.lock();
		try {
			for (int i = 1; i <= 5; i++) {
				log.info("write(): Thread Name: " + Thread.currentThread().getName() + "  Writing: " + i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			writeLock.unlock();
		}

	}

}

class ReadThread implements Runnable {
	private SharedObject sharedObject;

	public ReadThread(SharedObject sharedObject) {
		this.sharedObject = sharedObject;
	}

	@Override
	public void run() {
		sharedObject.read();
	}
}

class WriteThread implements Runnable {
	private SharedObject sharedObject;

	public WriteThread(SharedObject sharedObject) {
		this.sharedObject = sharedObject;
	}

	@Override
	public void run() {
		sharedObject.write();
	}
}

public class ReentrantReadWriteLockDemo {
	public static void main(String arr[]) {
		SharedObject sharedObject = new SharedObject();
		Thread t1 = new Thread(new ReadThread(sharedObject), "ReadThread1");
		Thread t2 = new Thread(new ReadThread(sharedObject), "ReadThread2");
		
		Thread t3 = new Thread(new WriteThread(sharedObject), "WriteThread1");
		Thread t4 = new Thread(new WriteThread(sharedObject), "WriteThread2");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
