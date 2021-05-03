package com.mypack;
import java.util.*;
public class FactoryDemo
{
    public static void main(String arr[])throws Exception
    {
        Scanner in=new Scanner(System.in);
        //System.out.println("Enter Class name");
        //String s=in.nextLine();
        A a=(A)Factory.getObject();
        a.display();
    }
}
class A
{
    public void display()
    {
        System.out.println("display() of A");
    }
}
class B
{
    public void display()
    {
        System.out.println("display() of B");
    }
}
class C
{
    public void display()
    {
        System.out.println("display() of C");
    }
}
class Factory
{
    public static Object getObject() throws Exception
    {
        Class c=Class.forName("A.class");
        Object o=c.newInstance();
        return o;
    }
}