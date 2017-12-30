package com.mypack.primitive.wrapper;

public class Test1 {

	public static void main(String[] args) {
		
		Integer a = 100;
		Integer b = 100;
		System.out.println(a.hashCode() + "    " + b.hashCode());
		System.out.println(a == b);
		
		System.out.println(Integer.valueOf("127")==Integer.valueOf("127"));
		System.out.println(Integer.valueOf("128")==Integer.valueOf("128"));
		System.out.println(Integer.parseInt("128")==Integer.valueOf("128"));
		
		String intValue = null;
		//int checkForZero = getInt();
		
		//System.out.println("checkForZero is : " + checkForZero);
		System.out.println("---------------------------");
		int test1 = 0175;
		
		System.out.println("test1 : " + test1);
	}
	
	
	static Integer getInt() {
		return null;
	}

}
