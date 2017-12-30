package com.mypack.overriding1;
class A
{
    public void display()
    {
        System.out.println("display");
        print();
    }
    public void print()
    {
        System.out.println("print() of A.");
    }
}
public class TestMethodCalling1 extends A
{
    public void print()
    {
        System.out.println("print() of TestMethodCalling1.");
    }
    public static void main(String arr[])
    {
        A test=new TestMethodCalling1();
        test.display();
    }
    
}
