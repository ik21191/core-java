package com.collection.array;
public class FindMaxValue {
	public static void main(String[] args) {
		int a[] = new int[] { 20, 13, 59, 9, 22, 33 };
		System.out.println("Max value available at " + findLargest(a) + " position ");
	}

	static int findLargest(int[] values) {
		int minIndex = 0; // start with 0th element as min
		for (int i = 1; i < values.length; i++) {
			if (values[i] < values[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}
}
