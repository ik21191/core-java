package com.mypack.thread.synchronize;
class SharedObject {//Because all the methods are synchronized in this case if any method gets the chance to execute then all the methods
	//will have to wait till completion of this method as the whole object is locked for that particular method. Non synchronized method
	//will not have lock
	public synchronized void method1() {
		System.out.println("method1 start");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("method1 end");
	}
	
	public synchronized void method2() {
		System.out.println("method2 start");
		System.out.println("method2 end");
	}
}

class T1 implements Runnable {
	private SharedObject sharedObject = null;
	public T1(SharedObject sharedObject) {
		this.sharedObject = sharedObject; 
	}
	@Override
	public void run() {
		sharedObject.method1();
	}
}

class T2 implements Runnable {
	private SharedObject sharedObject = null;
	public T2(SharedObject sharedObject) {
		this.sharedObject = sharedObject; 
	}
	@Override
	public void run() {
		sharedObject.method2();
	}
}
public class SharedResourceTest {
	public static void main(String arr[]) {
		SharedObject sharedObject = new SharedObject();
		Thread t1 = new Thread(new T1(sharedObject), "Thread1");
		Thread t2 = new Thread(new T2(sharedObject), "Thread2");
		t1.start();
		t2.start();
	}
}
