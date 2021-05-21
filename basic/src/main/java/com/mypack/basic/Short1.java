package com.mypack.basic;
public class Short1 {
	public static void main(String[] args) {
		byte a=127;//a=127+ will show an error at compile time
		int b=a;
		b=129;
		byte c=(byte)b;
		System.out.println(c);
	}
}
