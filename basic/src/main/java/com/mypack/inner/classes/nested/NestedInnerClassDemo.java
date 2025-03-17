package com.mypack.inner.classes.nested;

import com.mypack.inner.classes.nested.Outer.StaticInner;

class X {

}

class Outer {
	private X x = new X();
	private static X staticX = new X();

	class Inner {
		public void innerDisplay() {
			// Inner class can access private member of Outer class
			System.out.println("Accessing private member of Outer class: " + x);
		}
	}

	static class StaticInner {
		public void dislay() {
			System.out.println(staticX);
		}

		public static void print() {
			System.out.println("print() of StaticInner");
		}
	}
}

public class NestedInnerClassDemo {

	public static void main(String[] args) {
		Outer.Inner inner = new Outer().new Inner();
		inner.innerDisplay();

		// creating instance of StaticInnerClass
		StaticInner staticInner = new Outer.StaticInner();
		staticInner.dislay();

		StaticInner.print();
	}
}
