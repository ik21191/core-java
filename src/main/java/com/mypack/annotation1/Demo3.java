package com.mypack.annotation1;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class Demo3
{
    @MyAnnotation
    public int marks=100;
    public static void toPrint()
    {
        System.out.println("toPrint() of Demo1");
    }
    public static void showAnnotationInfo()
    {
        Demo3 demo=new Demo3();
        try
        {
            Class c=demo.getClass();
            Field f1=c.getField("marks");
            System.out.println("Checking whether the annotation is present or not on field marks......");
            System.out.println("-------------------------------------");
            if(f1.isAnnotationPresent(MyAnnotation.class))
                System.out.println("YES");
            else
                System.out.println("NO");
            System.out.println("-------------------------------------");
            MyAnnotation an=(MyAnnotation)f1.getAnnotation(MyAnnotation.class);
            System.out.println("Printing MyAnnotation informations.........");
            System.out.println("Value of the marks field is "+f1.getName());
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String arr[])
    {
        showAnnotationInfo();
    }
    
}
