package com.mypack.enums;

import java.util.ArrayList;
import java.util.List;

public class TestApp2 {

	public static void main(String[] args) {
		
		System.out.println(Test2.IEEE1.getMessage());
		List<Test2> list = new ArrayList<Test2>();
		list.add(Test2.IEEE1);
		list.add(Test2.IEEE2);
		list.add(Test2.IEEE3);
		//System.out.println(list);
	}
}
