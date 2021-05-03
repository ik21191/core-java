package com.mypack.thread.misc;

import org.apache.log4j.Logger;

class RunnableTest implements Runnable {
	private static final Logger log = Logger.getLogger(RunnableTest.class);
	private String name;
	
	public RunnableTest(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			log.error(e);
		}
		log.info("Thread Name: " + Thread.currentThread().getName() + " name: " + name);
	}
}

public class ThreadSafeDemo {
	
	public static void main(String[] args) {
		//All these thread contains different country name because each will contains a separate name variable
		Thread t1 = new Thread(new RunnableTest("INDIA"), "Thread-1");
		Thread t2 = new Thread(new RunnableTest("USA"), "Thread-2");
		Thread t3 = new Thread(new RunnableTest("CANADA"), "Thread-3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
