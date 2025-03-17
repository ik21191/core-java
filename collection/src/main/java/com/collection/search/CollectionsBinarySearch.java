package com.collection.search;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsBinarySearch {
    public static Integer binarySearch(List<Integer> list, Integer key) {
    	return Collections.binarySearch(list, 14);
    }
    public static void main(String[] args) {
    	List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10);
        list.add(20);
 
        // 10 is present at index 3.
        int index = Collections.binarySearch(list, 10);
        System.out.println(index);
 
        // 13 is not present. 13 would have been inserted
        // at position 4. So the function returns (-4-1) 
        // which is -5.
        index = Collections.binarySearch(list, 15);
        System.out.println(index);
    }
}
