package com.mypack.thread1;

import org.apache.log4j.Logger;

class MyThread extends Thread {
	public static final Logger log = Logger.getLogger(MyThread.class);
	
	public static void display(String threadName) {
		log.info(threadName + "  " + "before critical section");
		synchronized (MyThread.class) {
			for (int i = 1; i <= 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					log.error(e);
				}
				log.info(threadName + "  " + i);

			}
		}
		log.info(threadName + "  " + "after critical section");
	}

	public MyThread(String threadName) {
		super(threadName);
	}

	public MyThread() {
		log.info("defaul constructor of MyThread1");
	}

	@Override
	public void run() {
		display(getName());
	}
}

public class Test2 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("Thread1");
		MyThread t2 = new MyThread("Thread2");
		t1.start();
		t2.start();
	}

}
