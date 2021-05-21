package com.mypack.inner.classes.nested;

class Y {
	public void methodY() {
		System.out.println("methodY of Y");
	}
}
class Outer1 {
	
	public Y outerDisplay() {
		Y y = new Y();
		//Till java7 we could not used local variable of a method in Inner class without final
		int x = 100;// local variable in outer method of Outer class
		
		class Inner {
			private void innerDisplay() {
				
				System.out.println("value of x is : " + x);
				//You can use outer member variable but can not change it
				//x = 101; // This will give compile time error
				//error: Local variable x defined in an enclosing scope must be final or effectively final
				
			}
		}
		Inner inner = new Inner();
		inner.innerDisplay();
		return y;
	}
}
public class MethodLocalInnerClassDemo {

	public static void main(String[] args) {
		Outer1 outer = new Outer1();
		Y y = outer.outerDisplay();
		y.methodY();
    }

}


