package com.mypack.thread.misc;

import org.apache.log4j.Logger;

public class InterruptDemo extends Thread {
	private static final Logger log = Logger.getLogger(InterruptDemo.class);
	
	public InterruptDemo(String threadName) {
		super(threadName);
	}
	
	@Override
	public void run() {
		log.info(Thread.currentThread().getName() + " run() is called. Waiting for completion");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			log.info(e);
		}
		System.out.println(Thread.currentThread().getName() + " Completed");
	}

	public static void main(String[] args) throws Exception {
		InterruptDemo interruptDemo = new InterruptDemo("Thread1");
		interruptDemo.start();
		
		Thread.sleep(1000);
		interruptDemo.interrupt();
		log.info(interruptDemo.isInterrupted());
		log.info(Thread.currentThread().getName() + "Completed");
		interruptDemo.start();

	}

}
