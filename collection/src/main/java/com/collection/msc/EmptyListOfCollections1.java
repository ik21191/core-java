package com.collection.msc;
import java.util.*;
public class EmptyListOfCollections1
{
    public static void main(String arr[])throws Exception
    {
    	List<String> fixedSizeList = Arrays.asList(new String[]{"Imran", "Arpit", "Gautam Kumar"});
		//fixedSizeList.add("Rahul");//throw UnsupportedOperationException
		List<String> normalList = new ArrayList<>();
		normalList.add("ABC");
		List<String> list = Collections.emptyList();
		//list = normalList;
		list.add("Imran");
		System.out.println(list.size());
    }
}
