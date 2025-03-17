package com.collection;
import java.io.*;
import java.util.*;
public class Map1
{
    public static void main(String arr[])throws Exception
    {
       Map<String,String> map=new HashMap<String,String>();
       File dir=new File("/root/Desktop/aa/");
       String fname="value.txt";
       FileInputStream in =new FileInputStream(dir+"/"+fname);
       Properties pr=new Properties();
       pr.load(in);
       Enumeration e=pr.propertyNames();
       String nn=null;
       String yy=null;
        while(e.hasMoreElements())
        {
            nn=(String)e.nextElement();
            yy=pr.getProperty(nn);
            map.put(nn, yy);
            
            
        }
        if(dir.isDirectory())
        {
           //Files f=
        }
        System.out.println("Displaying map value:");
        System.out.println(map.get("2"));
        map.remove("1");
        System.out.println("Removed successfully");
        System.out.println(map.get("1"));
    }
}
