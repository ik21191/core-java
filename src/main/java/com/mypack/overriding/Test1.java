package com.mypack.overriding;
class X
{
    
}
class Y extends X
{
    
}
public class Test1
{
    public void print(X x)
    {
        System.out.println("X version");
    }
    public void print(Y x)
    {
        System.out.println("Y version");
    }       
    public static void main(String arr[])
    {
        Test1 test=new Test1();
        X x=new Y();
        test.print(x);
        test.print(new Y());
        test.print(new X());
        
    }
}
