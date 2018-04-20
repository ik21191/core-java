package com.mypack.thread.deadlock;

class Resource1 {
	
}

class Resource2 {
	
}

public class DeadLockDemo {

	public static void main(String[] args) {
		
		Resource1 resource1 = new Resource1();
		Resource2 resource2 = new Resource2();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized(resource1) {
					try {
						System.out.println(Thread.currentThread().getName() + " got the lock on resource1 and trying to lock on resource2....");
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println(e);
					}
					synchronized(resource2) {
						
					}
				}
				
			}
		}, "Thread-1");
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized(resource2) {//replace 2 with 1
					System.out.println(Thread.currentThread().getName() + " got the lock on resource2 and trying to lock on resource1....");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println(e);
					}
					synchronized(resource1) {//replace 1 with 2 then it will not create deadlock situation and this is called re-ordering resource
						
					}
				}
				
			}
		}, "Thread-2");
		
		t1.start();
		t2.start();
	}

}
