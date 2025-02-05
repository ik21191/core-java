package com.mypack.inner.classes.nested;

import java.util.ArrayList;
import java.util.List;

public class StaticNestedClassDemo {
	
	public static void outerMethod() {
		System.out.println("outerMethod of StaticNestedClassDemo");
	}
	
	private List<Inner> myList;
	
	public void put(String key, String value) {
		if(myList == null) {
			myList = new ArrayList<>();
		}
		Inner inner = new Inner();
		inner.setKey(key);
		inner.setValue(value);
		myList.add(inner);
	}
	
	public int size() {
		if(myList == null) {
			return 0;
		} else {
			return myList.size();
		}
	}
	
	public List<Inner> getList() {
		return this.myList;
	}

	static class Inner {
		private String key;
		private String value;
		
		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		StaticNestedClassDemo staticNestedClassDemo = new StaticNestedClassDemo();
		System.out.println("Size of the list is :  " + staticNestedClassDemo.size());
		
		System.out.println("Adding values in myList.....");
		staticNestedClassDemo.put("101", "Imran Khan");
		staticNestedClassDemo.put("102", "Vijay Kumar");
		staticNestedClassDemo.put("103", "Rakesh");
		staticNestedClassDemo.put("104", "Vinay");
		staticNestedClassDemo.put("105", "Raj");
		System.out.println("Added values in the list.");
		System.out.println("Size of the list is :  " + staticNestedClassDemo.size());
		
		System.out.println("Printing myList....");
		List<StaticNestedClassDemo.Inner> list = staticNestedClassDemo.getList();
		
		for(StaticNestedClassDemo.Inner entry : list) {
			System.out.println("key:   " + entry.getKey() + "  ,     value: " + entry.getValue());
		}
	}
	
}
