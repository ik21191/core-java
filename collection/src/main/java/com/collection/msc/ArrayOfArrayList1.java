package com.collection.msc;

import java.util.ArrayList;

public class ArrayOfArrayList1 {
	public static void main(String arr[]) {
		ArrayList<A> list = new ArrayList<>();
		list.add(new A("Imran Khan"));
		list.add(new A("Vinay Kumar"));
		list.add(new A("Chandan Trikha"));
		list.add(new A("Rahul Tyagi"));
		Object[] ob = list.toArray();
		for (Object name : ob) {
			((A) name).display();
		}
	}
}

class A {
	String name;

	A(String name) {
		this.name = name;
	}

	public void display() {
		System.out.println("Name is " + name);
	}
}