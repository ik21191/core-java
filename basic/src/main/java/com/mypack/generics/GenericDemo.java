package com.mypack.generics;

class MyGeneric<T> {
	private T t;
	
	public MyGeneric(T t) {
		this.t = t;
	}
	
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
}

public class GenericDemo {

	public static void main(String[] args) {
		MyGeneric<Integer> o1 = new MyGeneric<>(100);
		System.out.println(o1.getT());
		
		MyGeneric<String> o2 = new MyGeneric<>("Hello World !");
		System.out.println(o2.getT());
		
		MyGeneric<Character> o3 = new MyGeneric<>('A');
		System.out.println(o3.getT());

	}

}
