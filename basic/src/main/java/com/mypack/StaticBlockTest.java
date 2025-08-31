package com.mypack;

class StaticBlock {

  static {
    //will throw below error 
	//Caused by: java.lang.ArithmeticException: / by zero
    System.out.println(1/0); 
  }

  public static void displayHello() {
    System.out.println("Hello");
  }
}

public class StaticBlockTest {
  public static void main(String[] args) {
    /**
     * Below method call will not be executed because we will get an exception while executing static block during the
     * class load and because of this the class will not load in the memory.
     * */
    StaticBlock.displayHello();
  }
}
