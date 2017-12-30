package com.mypack.thread.synchronize;
class MyThreadThis extends Thread
{
	public void display(String threadName)
	{
		System.out.println(threadName+"  "+"before critical section");
		synchronized(this)
		{
			for(int i=1;i<=10;i++)
			{
				try{Thread.sleep(1000);}catch(Exception e){System.out.println(e);}
				System.out.println(threadName+"  "+i);
				
			}
		}
		System.out.println(threadName+"  "+"after critical section");
	}
	public MyThreadThis(String threadName)
	{
		super(threadName);
	}
	public MyThreadThis(){
		System.out.println("defaul constructor of MyThread1");
	}
	
	@Override
	public void run() 
	{
		display(getName());
	}
}

public class SynchronizeWithThis 
{
	public static void main(String[] args) 
	{
		MyThread t1=new MyThread("Thread1");
		MyThread t2=new MyThread("Thread2");
		t1.start();
		t2.start();
	}

}
