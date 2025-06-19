package com.mypack;

public class AmbiguousMethodCalling1 {
  
  protected void display() {
    System.out.println("display() of AA.");
  }

  public static void print(X x) {
    System.out.println("print() X method is called: " + x);
  }

  public static void print(Object y) {
    System.out.println("print() Y method is called: " + y);
  }

  public static void main(String arr[]) {
    print(null);// No ambiguous compile time error because by default X extends Object
    System.out.println();
  }
}
