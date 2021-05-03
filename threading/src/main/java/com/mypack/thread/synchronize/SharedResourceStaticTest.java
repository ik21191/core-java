package com.mypack.thread.synchronize;
class SharedObject1 {
	/**Because all the methods are synchronized in this case if any method gets the chance to execute then all the methods
	will have to wait till completion of this method as the whole object is locked for that particular method.
	*/
	public static void method1() {
		synchronized(SharedObject1.class) {
			System.out.println("method1 start");
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("method1 end");
		}
	}
	
	public static void method2() {
		synchronized(SharedObject1.class) {
			System.out.println("method2 start");
			System.out.println("method2 end");
		}
	}
}

class T3 implements Runnable {
	@Override
	public void run() {
		SharedObject1.method1();
	}
}

class T4 implements Runnable {
	@Override
	public void run() {
		SharedObject1.method2();
	}
}
public class SharedResourceStaticTest {
	public static void main(String arr[]) {
		Thread t1 = new Thread(new T3(), "Thread1");
		Thread t2 = new Thread(new T4(), "Thread2");
		t1.start();
		t2.start();
	}
}
