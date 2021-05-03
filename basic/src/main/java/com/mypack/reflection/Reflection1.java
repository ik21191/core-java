package com.mypack.reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
public class Reflection1
{
    private int a;
    public int b;
    private double c;
    String name;
    char ch;
    public void display()
    {a=100;b=100;
        System.out.println("Addition of a and b is  "+(a+b));
    }
    public String print(String x)
    {
        return x;
    }
    public int return100()
    {
        return 100;
    }
    public static void main(String arr[])throws Exception
    {
        Class cls=Class.forName("com.mypack.reflection.Reflection1");
        System.out.println("Getting all the fields of Reflection1 class..............");
        Field[] classFields=cls.getDeclaredFields();
        for(int i=0;i<classFields.length;i++)
        System.out.println("Field name: "+classFields[i].getName()+"  Type:  "+classFields[i].getType()
        +"  Modifier:  "+Modifier.isStatic(classFields[i].getModifiers()));
        System.out.println("\n\nGetting all the methods of Reflection1 class...........");
        Method[] methods=cls.getDeclaredMethods();
        for(int i=0;i<methods.length;i++)
        System.out.println(methods[i].getName());
        System.out.println("\n\nGetting all the constructors of the class reflection.Reflection1 ..........");
        Constructor cons[]=cls.getDeclaredConstructors();
        for(int i=0;i<cons.length;i++)
        System.out.println(cons[i].getName());
        System.out.println("\n\nCalling display() of reflection.Reflection1 class ...............");
        //Object o=cls.newInstance();
        //Method m=cls.getDeclaredMethod("display",null);//if display() is private
        Object o=cls.newInstance();
        Method m=cls.getMethod("display",null);
        m.invoke((Reflection1)o,null);
        System.out.println("Calling method and displaying its return type..........");
        m=cls.getMethod("return100",null);
        System.out.println("Return Value is   "+m.invoke(o,null));
        System.out.println("Calling method while passing arguement................");
        Class[] c=new Class[1];
        c[0]=String.class;
        Object[] arg=new Object[1];
        arg[0]=new String("This is Imran Khan");
        m=cls.getMethod("print",c);
        System.out.println(m.invoke(o,arg));
    }
}
