package com.collection.compareto;
import java.util.*;
public class AddStudent
{
    public static void main(String arr[])throws Exception
    {
        //TreeSet<Student> list=new TreeSet<Student>();
        //TreeSet<Student> list=new TreeSet<Student>(new CourceComparator());
        TreeSet<Student> list = new TreeSet<>(new FeeComparator());
        list.add(new Student(7000,"Imran Khan","j2ee"));
        list.add(new Student(6500,"Vinay Kumar","php"));
        list.add(new Student(8500,"Abhisek Dua","mysql"));
        list.add(new Student(3500,"Vikas Kumar","hibernate"));
        System.out.println("Dispalying record......");
        Iterator<Student> itr=list.iterator();
        while(itr.hasNext()) { 
            Student s=itr.next();
            s.display();
        }
    }
}
