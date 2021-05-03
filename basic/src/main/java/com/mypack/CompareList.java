package com.mypack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CompareList {

	public static void main(String[] args) throws Exception {
		List<List<String>> sourceList = new ArrayList<List<String>>();
		List<List<String>> targetList = new ArrayList<List<String>>();
		
		FileReader input1 = new FileReader("e:/file1.csv");
	    BufferedReader br1 = new BufferedReader(input1);
	    
	    FileReader input2 = new FileReader("e:/file2.csv");
	    BufferedReader br2 = new BufferedReader(input2);

	    String line = null;
	    //Reading file1
	    while ((line = br1.readLine()) != null) {
	        String ar[] = line.split(",");
	        List<String> list = new ArrayList<>();
	        if(ar.length == 1) {
	        	list.add(ar[0]);
	        } else {
	        	for(String string : ar) {
	        		list.add(string);
	        	}
	        }
	        sourceList.add(list);
	    }
	    
	    //reading file2
	    while ((line = br1.readLine()) != null) {
	        String ar[] = line.split(",");
	        List<String> list = new ArrayList<>();
	        if(ar.length == 1) {
	        	list.add(ar[0]);
	        } else {
	        	for(String string : ar) {
	        		list.add(string);
	        	}
	        }
	        targetList.add(list);
	    }
	    
	    for(List<String> source: sourceList) {
	    	for(String str: source) {
	    		for(List<String> target : targetList) {
	    			
	    		}
	    	}
	    }
	    
	    br1.close();
	    br2.close();
	}

}
