package com.mypack.thread.synchronize;

import org.apache.log4j.Logger;

class Sharable {
	private static Logger log = Logger.getLogger(SharedObject.class);
	
	public void display() throws Exception {
		for (int i = 1; i <= 5; i++) {
			Thread.sleep(1000);
			log.info(Thread.currentThread().getName() + "  " + i);
		}
	}
	
}

public class ResourceUsage implements Runnable {
	private static Logger log = Logger.getLogger(ResourceUsage.class);
	Sharable sharedObject;
	
	public ResourceUsage(Sharable sharedObject) {
		this.sharedObject = sharedObject;
	}
	
	@Override
	public void run() {
		try {
			log.info("run() " + Thread.currentThread().getName());
			/**Below sharedObject works as a monitor so whenever any method of this object is executing by a thread then this object will 
			  get the lock on that thread and will release the lock after completion of the method */
			synchronized (sharedObject) {
				sharedObject.display();
			}
		} catch (Exception e) {
			log.error(e);
		}

	}
	
	public static void main(String[] arr) {
		Sharable sharedObject = new Sharable();
		Thread thread1 = new Thread(new ResourceUsage(sharedObject), "Thread1");
		Thread thread2 = new Thread(new ResourceUsage(sharedObject), "Thread2");
		thread1.start();
		thread2.start();
	}
}
