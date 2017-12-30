package com.mypack.test1;
interface A
{
    interface B
    {
        void display();
    }
}
public class ExtendsInterface1 implements A.B
{
    public void display() 
    {
        System.out.println("display() fo A.B inner interface.");
    }
    public static void main(String arr[])
    {
        A.B b=new ExtendsInterface1();
        b.display();
    }
}
