package com.mypack.access.modifier;

import com.mypack.AmbiguousMethodCalling;

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
