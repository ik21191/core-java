package com.mypack.access.modifier;

import com.mypack.AmbiguousMethodCalling;

class MyParent {
  public void display() {
    System.out.println("display() ");
  }
}

public class AccessModifierDemo extends AmbiguousMethodCalling {
	public void displayAA() {
		AmbiguousMethodCalling a = new AmbiguousMethodCalling();
		System.out.println("Value of AA.aa is " + aa);
	}

	public static void main(String arr[]) {
		AccessModifierDemo use = new AccessModifierDemo();
		use.display();
	}
}
