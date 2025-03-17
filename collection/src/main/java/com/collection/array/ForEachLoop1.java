package com.collection.array;

import java.util.*;

public abstract class ForEachLoop1 {
	public abstract void display();

	public static void print() {
		System.out.println("print()");
	}

	public static void main(String arr[]) {
		print();
		int a[] = new int[10];
		int j = 1;
		System.out.println("Printing array......" + a.length);
		for (int i : a) {
			System.out.println(j * 2);
			j++;
		}
		System.out.println("Printed");
		System.out.println("Printing colletion.........");
		// HashSet<Integer> list=new HashSet<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		/*
		 * for (int k:list)//This for loop is still possible {
		 * System.out.println(k); }
		 */
		// int i=new Integer(100);
		for (Integer k : list) {
			System.out.println(k);
		}
	}
}
