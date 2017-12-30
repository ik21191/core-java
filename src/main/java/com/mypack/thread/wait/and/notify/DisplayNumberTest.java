package com.mypack.thread.wait.and.notify;

import org.apache.log4j.Logger;

class DisplayNumber {
	private static final Logger log = Logger.getLogger(DisplayNumber.class);
	public void print() {
		for(int i=1; i<=5; i++) {
			log.info(Thread.currentThread().getName() + " : " + i);
		}
	}
}
class MyNotifier implements Runnable {
	
	DisplayNumber displayNumber = null;
	
	public MyNotifier(DisplayNumber displayNumber) {
		
		this.displayNumber = displayNumber;
	}
	@Override
	public void run() {
		synchronized(displayNumber) {
			displayNumber.notifyAll();
			//displayNumber.notify();//If we have multiple thread in waiting state then only one thread is notified, rest will be in waiting
		}
	}
}
class MyThread implements Runnable {
	private static final Logger log = Logger.getLogger(MyThread.class);
	DisplayNumber displayNumber = null;
	
	public MyThread(DisplayNumber displayNumber) {
		
		this.displayNumber = displayNumber;
	}
	@Override
	public void run() {
		synchronized(displayNumber) {
			try {
				displayNumber.wait();
			} catch (InterruptedException e) {
				log.error(e);
			}
			displayNumber.print();
		}
	}
}

public class DisplayNumberTest {
	
	public static void main(String arr[]) throws InterruptedException {
		DisplayNumber displayNumbernew = new DisplayNumber();
		Thread t1 = new Thread(new MyThread(displayNumbernew), "Thread1");
		Thread t2 = new Thread(new MyThread(displayNumbernew), "Thread2");
		Thread t3 = new Thread(new MyNotifier(displayNumbernew), "NotifierThread3");
		t1.start();
		t2.start();
		t3.start();
	}
}