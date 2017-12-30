package com.mypack.test1;
import java.util.*;
interface AAA
{   
    public void display(Object o);
}   
public class Test 
{
    public static void main(String arr[])
    {
        Map m=new TreeMap();
        m.put("1","one");
        m.put("1","two");
        System.out.println(m.size());
        Set s=new TreeSet();
        System.out.println(s.add("1"));
        System.out.println(s.add("1"));// You can add any number of keys but last one will be affected
        System.out.println("Case:    2");
    }
}
