package com.collection.msc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class ConcurrentModificationTest {
	public static void listIteratorAdd() {
		List<String> list = new ArrayList<String>();
		list.add("Imran Khan");
		list.add("Vinay Kumar");
		list.add("Gautam Kumar");
		ListIterator<String> listIterator = list.listIterator();
		System.out.println("Before Adding : " + list);
		while(listIterator.hasNext()) {
			if(listIterator.next().contains("Imran Khan")) {
				listIterator.add("Rahul Kumar");
			}
		}
		System.out.println("After Adding  : " + list);
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		Iterator<String> itr = list.iterator();
		//System.out.println(list.remove("A"));//You can't remove element structurally after creating its Iterator. It will throw ConcurrenModificationException
		while(itr.hasNext()) {
			System.out.println(itr.next().hashCode());
			if(list.contains("A")) {
				itr.remove();//It will not throw ConcurrenModificationException
			}
			//System.out.println(list.remove("A"));//It will throw ConcurrenModificationException
		}
		System.out.println(list);
		System.out.println("listIteratorAdd() is called");
		listIteratorAdd();
	}

}
