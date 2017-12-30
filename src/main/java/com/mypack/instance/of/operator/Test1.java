package com.mypack.instance.of.operator;
interface I
{
	
}
class ImplI implements I
{
	
}
class A
{
    public void print()
    {
        System.out.println("print of A");
    }
}
class B extends A
{
    public void print()
    {
        System.out.println("print of B");
    }
}
public class Test1 
{
    public static void main(String arr[])
    {
        A a=new A();
        A b=new B();
        ((B)b).print();
        B bb=new B();
        A aa=(A)bb;
        aa.print();
        if( a instanceof B){
            System.out.println("a is an object of B");
        }
        I i=new ImplI();
        System.out.println(i instanceof I);
    }
}
