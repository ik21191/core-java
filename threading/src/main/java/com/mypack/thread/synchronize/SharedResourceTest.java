package com.mypack.thread.synchronize;
class SharedObject {
	/**Because all the methods are synchronized in this case if any method gets the chance to execute then all the methods
	will have to wait till completion of this method as the whole object is locked for that particular method. Non synchronized method
	will not have lock*/
	
	/*method3 is not synchronized and we don't have object level lock, in that case if any thread can
	 * call method3 even other thread is executing in synchronized method*/
	
	public void method1() {
		synchronized (this) {
			System.out.println("method1 start");
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("method1 end");
		}
	}
	
	
	/** This method works the same as above method, but we have used synchronized keyword in the header of method
	public synchronized void method1() {
		System.out.println("method1 start");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("method1 end");
	}*/
	
	public synchronized void method2() {
		synchronized (this) {
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("method2 start");
			System.out.println("method2 end");
		}
	}
	
	/** This method works the same as above method, but we have used synchronized keyword in the header of method
	public synchronized void method2() {
		System.out.println("method2 start");
		System.out.println("method2 end");
	}*/
	
	public void method3() {
		System.out.println("method3 start");
		System.out.println("method3 end");
	}
}

class T1 implements Runnable {
	private SharedObject sharedObject;
	public T1(SharedObject sharedObject) {
		this.sharedObject = sharedObject; 
	}
	@Override
	public void run() {
		sharedObject.method1();
	}
}

class T2 implements Runnable {
	private SharedObject sharedObject;
	public T2(SharedObject sharedObject) {
		this.sharedObject = sharedObject; 
	}
	@Override
	public void run() {
		sharedObject.method2();
	}
}

class T8 implements Runnable {
	private SharedObject sharedObject;
	public T8(SharedObject sharedObject) {
		this.sharedObject = sharedObject; 
	}
	@Override
	public void run() {
		sharedObject.method3();
	}
}
public class SharedResourceTest {
	public static void main(String arr[]) throws Exception {
		SharedObject sharedObject = new SharedObject();
		Thread t1 = new Thread(new T1(sharedObject), "Thread1");
		Thread t2 = new Thread(new T2(sharedObject), "Thread2");
		t1.start();
		t2.start();
		Thread.sleep(2000);
		Thread t3 = new Thread(new T8(sharedObject), "Thread3");
		t3.start();
	}
}
