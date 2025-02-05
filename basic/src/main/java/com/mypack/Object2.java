package com.mypack;
interface MyInterface
{
    public void display(Object t);
}
public class Object2 implements MyInterface
{
    public void display(Object o)
    {
        System.out.println("display(Object ) in Object2");
    }
    public void display(Object2 o)
    {
        System.out.println("display(Object ) in Object2");
    }
}
