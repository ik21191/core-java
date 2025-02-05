package com.mypack.thread1;
class MyThread1 implements Runnable {
	 @Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " executing...");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " ended.");
		
	}
}
public class JoinDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MyThread1(), "Thread 1");
		Thread t2 = new Thread(new MyThread1(), "Thread 2");
		Thread t3 = new Thread(new MyThread1(), "Thread 3");
		
		t1.start();
		t2.start();
		t3.start();
		

		/* If we uncomment and run the program then thread will run in Sequencial order.
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		*/
	}

}
