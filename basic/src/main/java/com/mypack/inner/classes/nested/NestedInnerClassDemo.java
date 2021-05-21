package com.mypack.inner.classes.nested;
class X {
	
}
class Outer {
	private X x = new X();
	class Inner {
		public void innerDisplay() {
			//Inner class can access private member of Outer class
			System.out.println("Accessing private member of Outer class: " + x); 
		}
	}
}
public class NestedInnerClassDemo {

	public static void main(String[] args) {
		Outer.Inner inner = new Outer().new Inner();
		inner.innerDisplay();

	}

}
