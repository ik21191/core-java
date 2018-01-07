package com.mypack.thread;
import java.util.Scanner;
class Name
{
    private static Name n;
    private static String name;

    public static Name getN() {
        if(n==null)
        {
            System.out.println("if block");
            n=new Name();
            return n;}
        else{
            System.out.println("else block");
            return n;}
    }
    public String getName() {
        return name;
    }

    public static void setName(String xx) {
        name=xx;
    }
    
}
class MyThread implements Runnable
{String tname;
    MyThread(String n)
    {
        tname=n;
    }
    public void run()
    {
        call();
    }
    public synchronized void call()
    {
            Scanner in=new Scanner(System.in);
            System.out.println("Enter values of name Thread name: "+tname);
            String nn=in.nextLine();
            Name.setName(nn);
            display();
            in.close();
    }
    public void display()
    {
        System.out.println("value of name variable of the thread "+tname+" is :"+Name.getN().getName());
    }
}

public class Demo1
{
    public static void main(String arr[])
    {
        MyThread o1=new MyThread("th1");
        MyThread o2=new MyThread("th2");
        Thread t1=new Thread(o1,"Thread 1");
        Thread t2=new Thread(o2,"thread 2");
        t1.start();
        t2.start();
    }
}
