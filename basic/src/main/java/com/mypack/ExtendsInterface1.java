package com.mypack;
interface A1
{
    interface B
    {
        void display();
    }
}
public class ExtendsInterface1 implements A1.B
{
    public void display() 
    {
        System.out.println("display() fo A.B inner interface.");
    }
    public static void main(String arr[])
    {
        A1.B b=new ExtendsInterface1();
        b.display();
    }
}
