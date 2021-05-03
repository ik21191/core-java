package com.mypack.inerfaces;
interface XX
{
    public void print(Object o);
}
class YY
{
    public void display()
    {
        System.out.println("display() of YY.");
    }
}
public class Test1 implements XX
{
    /*public void print(YY y)
    {
        System.out.println("print of Test1");
    }*/
    public void print(Object y)
    {
        System.out.println("print of Test1");
    }
}
