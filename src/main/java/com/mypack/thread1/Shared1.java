package com.mypack.thread1;
public class Shared1 implements Runnable {
	
	SharedObject obj = new SharedObject("Imran");
	
	@Override
	public void run(){
		System.out.println("Name of thread : " + Thread.currentThread().getName());
		System.out.println("Value of sharedName is : " + obj.getSharedName() + " : " +Thread.currentThread().getName());
	}
	public static void main(String arr[]){
		Thread t1 = new Thread(new Shared1(), "Thread1");
		Thread t2 = new Thread(new Shared1(), "Thread2");
		Thread t3 = new Thread(new Shared1(), "Thread3");
		t1.start();
		t2.start();
		t3.start();
	}
}
class SharedObject{
	String sharedName = "Imran";
	public SharedObject(String sharedName) {
		this.sharedName= sharedName;
	}
	public void changeName(String sharedName){
		this.sharedName = sharedName;
	}
	public String getSharedName(){
		return this.sharedName;
	}
}
