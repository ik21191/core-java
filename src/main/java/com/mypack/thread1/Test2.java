package com.mypack.thread1;
class MyThread extends Thread
{
	public static void display(String threadName)
	{
		System.out.println(threadName+"  "+"before critical section");
		synchronized(MyThread.class)
		{
			for(int i=1;i<=10;i++)
			{
				try{Thread.sleep(1000);}catch(Exception e){System.out.println(e);}
				System.out.println(threadName+"  "+i);
				
			}
		}
		System.out.println(threadName+"  "+"after critical section");
	}
	public MyThread(String threadName)
	{
		super(threadName);
	}
	public MyThread(){
		System.out.println("defaul constructor of MyThread1");
	}
	
	@Override
	public void run() 
	{
		display(getName());
	}
}

public class Test2 
{
	public static void main(String[] args) 
	{
		MyThread t1=new MyThread("Thread1");
		MyThread t2=new MyThread("Thread2");
		t1.start();
		t2.start();
	}

}
