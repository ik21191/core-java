package com.mypack.thread.misc;

import java.util.Random;

import org.apache.log4j.Logger;

class MyRandomNumber {
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}

class MyTask implements Runnable {
	private static final Logger log = Logger.getLogger(MyTask.class);
	private ThreadLocal<MyRandomNumber> threadLocal = new ThreadLocal<MyRandomNumber>(){
		@Override
		protected MyRandomNumber initialValue() {
			return new MyRandomNumber();
		}
	};
	
	@Override
	public void run() {
		threadLocal.set(new MyRandomNumber());
		try {
			log.info("Thread Name: " + Thread.currentThread().getName() + " Generating number");
			threadLocal.get().setNumber(new Random().nextInt(3));
			Thread.sleep(3000);
			log.info("Thread Name: " + Thread.currentThread().getName() + " Generated number");
		} catch (InterruptedException e) {
			log.error(e);
		}
		log.info("Thread Name: " + Thread.currentThread().getName() + " Number is: " + threadLocal.get().getNumber());
	}
}

public class ThreadLocalDemo {

	public static void main(String[] args) {
		MyTask task = new MyTask();
		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");
		Thread t3 = new Thread(task, "Thread-3");
		
		t1.start();
		t2.start();
		t3.start();		
	}
}
