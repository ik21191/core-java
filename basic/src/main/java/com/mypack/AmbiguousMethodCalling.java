package com.mypack;
class X {
	String name = "abc";
}
class Y //extends X 
{
	String name = "xyz";
}
public class AmbiguousMethodCalling {
    protected int aa = 100;
    protected void display() {
        System.out.println("display() of AA.");
    }
    public static void print(X x) {
    	System.out.println("print(X) method is called: " + x);
    }
    public static void print(Y x) {
    	System.out.println("print(Y) method is called: " + x);
    }
    public static void main(String arr[]) {
    	//print(null);//Ambiguous compile time error//If Y extends X then no error
    	print(new X());//But this will work because the type is resolved at compile time
    }
}
