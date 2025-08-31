package com.mypack;

public class BooleanDemo {
  public void display(boolean a, boolean b) {
    if (a) {
      System.out.println("A");
    }
    else if (a && b) {
      System.out.println("A and B");
    }
  }

  public static void main(String arr[]) {
    BooleanDemo bl = new BooleanDemo();
    bl.display(true, true);
  }
}
