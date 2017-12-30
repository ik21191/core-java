package com.mypack.thread.synchronize;

class A {
	public void method1() {
		System.out.println("method1 in A");
	}
}

public class Test {
	public static void main(String a[]) throws Exception {
		A objecta = new A();

		A objectb = new A();

		synchronized (objecta) {
			Thread.sleep(5000);
			objecta.method1();
		}

		objectb.method1(); // not synchronized
	}

}
