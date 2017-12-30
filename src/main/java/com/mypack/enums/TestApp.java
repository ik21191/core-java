package com.mypack.enums;

import java.util.ArrayList;
import java.util.List;

public class TestApp {

	public static void main(String[] args) {
		
		System.out.println(Test.ERROR1.getMessage());
		List<Test> list = new ArrayList<Test>();
		list.add(Test.ERROR1);
		list.add(Test.ERROR2);
		list.add(Test.ERROR3);
		//System.out.println(list);
		
		for(Test t : Test.values()) {
			System.out.println(t.getCode() + "   " + t.getMessage());
		}
	}
}
