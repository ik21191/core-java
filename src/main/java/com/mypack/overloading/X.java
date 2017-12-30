package com.mypack.overloading;
public class X
{
    public void display(int x)
    {
        System.out.println("display(int x)");
        
    }
    void display()
    {
        System.out.println("display()");
    }
    void display(double x)
    {
        System.out.println("display(double x)");
    }
    public void print()
    {
        System.out.println("public print() of Current Class");
    }
    public static void main(String arr[])
    {
        X x = new X();
        //double d = 10;
        //int d = 10;
        x.display(10.0);
    }
}
