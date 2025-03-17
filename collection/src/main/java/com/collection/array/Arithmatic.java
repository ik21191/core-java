package com.collection.array;

public class Arithmatic {
	public static void main(String[] args) {
		System.out.println("Sum of the number is : " + sumOfNumbers(2345));
		System.out.println("Lowercase Letters are : " + findSmallLetters("iMraN Khan"));
		int updated[] = findDuplicateCharacter(new int[] {1, 8, 4, 1, 2, 8});
		for(int i = 0; i < updated.length; i++) {
			System.out.print(updated[i] + " ");
		}
	}

	private static int sumOfNumbers(int num) {
		int sum = 0;
		for(;num != 0;) {
			sum = sum + (num % 10);
			num = num / 10;
		}
		return sum;
	}
	
	private static String findSmallLetters(String string) {
		String newString = "";
		char a[] = string.toCharArray();
		for(int i = 0; i < a.length ; i++) {
			if((int)a[i] >= 97 && (int)a[i] <= 120) {
				newString = newString + a[i];
			}
		}
		return newString;
	}
	
	private static int[] findDuplicateCharacter(int arr[]) {
		int index = 0;
		int tmp[] = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					tmp[index] = arr[i];
					index++;
				}
			}
		}
		int updated[] = new int[index];
		for(int i = 0; i < index; i++) {
			updated[i] = tmp[i];
		}
		return updated;
	}
}
