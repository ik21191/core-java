package com.collection.array;
public class Pagination1 
{
	static int list[] = new int []{
		1, 2,  3,  4, 
		5, 6,  7,  8, 
		9, 10 ,11, 12,
		13, 14, 15
		};
    public static void main(String arr[])
    {
    	pagination(4);
    }
    public static void pagination(int numberOfRecords) {
    	int pageNumber = 0;
    	Integer start = 0;
    	Integer next = 1;
    	Integer previous = null;
    	Integer noOfPages = 0;
    	if(list.length % numberOfRecords==0) {
    		noOfPages = list.length / numberOfRecords;
    	}else {
    		noOfPages = (list.length / numberOfRecords) + 1;
    	}
    	System.out.println(noOfPages);
    	if (next == null && previous == null) {
			pageNumber = 1;
		} else if (next != null) {
			pageNumber = next;
		} else if (previous != null) {
			pageNumber = previous;
		}
		start = ((numberOfRecords * pageNumber) - numberOfRecords);
		next = pageNumber + 1;
		previous = pageNumber - 1;
    	for(int j = 0; j < numberOfRecords; j++) {
    		int k = start++;
    		int l = k + 1;
    		if(l <=list.length) {
    			System.out.print(list[k] + "\t");
    		}
    	}System.out.println();
    	//Below conditions are for front end
    	if(next >= 1 && next <= noOfPages) {
    		System.out.println("Next");
    	}
    	if(previous >= 1 && previous <= noOfPages) {
    	System.out.println("Pre");
    	}
    }
}
