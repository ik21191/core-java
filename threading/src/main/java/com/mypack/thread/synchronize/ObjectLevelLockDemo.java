package com.mypack.thread.synchronize;

class Sharable1 {
	public void method1() throws Exception {
		for (int i = 1; i <= 5; i++) {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + "  " + i);
		}
	}
	
	public void method2() throws Exception {
		for (int i = 6; i <=10 ; i++) {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + "  " + i);
		}
	}
	
	public void method3() throws Exception {
		for (int i = 11; i <=15 ; i++) {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + "  " + i);
		}
	}
}


class T5 implements Runnable {
	Sharable1 sharedObject;
	
	public T5(Sharable1 sharedObject) {
		this.sharedObject = sharedObject;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("run() " + Thread.currentThread().getName());
			/*Object level lock: Using below we are making object level lock. Till sharedObject is locked
			 * then other thread will not able to execute any method of this object*/
			synchronized (sharedObject) {
				sharedObject.method1(); //This display method is non synchronized
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

class T6 implements Runnable {
	Sharable1 sharedObject;
	
	public T6(Sharable1 sharedObject) {
		this.sharedObject = sharedObject;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("run() " + Thread.currentThread().getName());
			/*Object level lock: Using below we are making object level lock. Till sharedObject is locked
			 * then other thread will not able to execute any method of this object*/
			synchronized (sharedObject) {
				sharedObject.method2(); //This display method is non synchronized
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

class T7 implements Runnable {
	Sharable1 sharedObject;
	
	public T7(Sharable1 sharedObject) {
		this.sharedObject = sharedObject;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("run() " + Thread.currentThread().getName());
			/*Object level lock: Using below we are making object level lock. Till sharedObject is locked
			 * then other thread will not able to execute any method of this object*/
			synchronized (sharedObject) {
				sharedObject.method3(); //This display method is non synchronized
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

public class ObjectLevelLockDemo {
	
	public static void main(String[] arr) {
		Sharable1 sharedObject = new Sharable1();
		Thread thread1 = new Thread(new T5(sharedObject), "Thread1");
		Thread thread2 = new Thread(new T6(sharedObject), "Thread2");
		Thread thread3 = new Thread(new T7(sharedObject), "Thread3");
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
