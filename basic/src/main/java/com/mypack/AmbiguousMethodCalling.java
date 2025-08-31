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

  public static void print(Y y) {
    System.out.println("print(Y) method is called: " + y);
  }

  /********************************/
  public static void display(X x) {
    System.out.println("display() X method is called: " + x);
  }

  public static void display(Object y) {
    System.out.println("display() Y method is called: " + y);
  }
  public static void main(String arr[]) {
    //print(null);//Ambiguous compile time error//If Y extends X then no error//output: print(Y) method is called: null
    print(new X());//But this will work because the type is resolved at compile time
  	
    display(null);// No ambiguous compile time error because by default X extends Object
  }
}
