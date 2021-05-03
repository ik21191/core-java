package com.mypack.string.logic;
public class ExtractString1
{
    public static void main(String ar[])throws Exception {
        //String name1="hello imran khan";
        //String name2="Imran";
        //System.out.println(name1.substring(name1.indexOf(name2)));
    	
    	String myString = "core/pages/viewemployee.jsff";
    	String newString = myString.substring(myString.lastIndexOf("/") + 1); 
    	System.out.println(newString);
        //String a="/laban/def/ghi";
        //System.out.println(a.substring(6));
    }
}
