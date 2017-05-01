package multipleThread.waitAndNotify;

class DisplayNumber {
	
	public void print() {
		for(int i=1; i<=5; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
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
			//displayNumber.notifyAll();
			displayNumber.notify();
		}
	}
}
class MyThread implements Runnable {
	
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
				// TODO Auto-generated catch block
				e.printStackTrace();
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
