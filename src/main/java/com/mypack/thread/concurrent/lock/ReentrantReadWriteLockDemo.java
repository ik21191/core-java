package com.mypack.thread.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedObject {
	ReadWriteLock rwLock = new ReentrantReadWriteLock();
	Lock readLock = rwLock.readLock();
	Lock writeLock = rwLock.writeLock();
	
	public void read() {
		readLock.lock();
		System.out.println("reading start..");
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println("read(): Thread Name: " + Thread.currentThread().getName() + "  Reading: " + i);
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			System.out.println(e);
		} finally {
			readLock.unlock();
		}
		System.out.println("reading end.");
	}
	

	public void write() {
		System.out.println("Writing startd ..");
		writeLock.lock();
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println("write(): Thread Name: " + Thread.currentThread().getName() + "  Writing: " + i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.err.println(e);
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
