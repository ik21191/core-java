package com.mypack;
class AA
{
    public String toString()
    {
        return "This object AA";
    }
    public void getObject(Object o)
    {
        Object1 o1=(Object1)o;
       o1.display(); 
    }
}
public class Object1
{
    public void display()
    {
        System.out.println("display() of Ojbect1");
    }
    public static void main(String arr[])
    {
       Object o=new AA();
       System.out.println(o);
       Object1 o2=new Object1();
       AA aa=new AA();
       aa.getObject(o2);
    }
}
