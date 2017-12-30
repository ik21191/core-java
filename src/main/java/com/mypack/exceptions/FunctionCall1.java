package com.mypack.exceptions;
public class FunctionCall1 
{
    public static int get()
    {
        try
        {
            //throw new Exception();
            return 1;
            
            //System.out.println("Unreachable code: compile time error");
        }catch(Exception e)
        {
            System.out.println("Exception is: "+e);
        }
        finally
        {
            System.out.println("finally block");
            //return 2;//if you uncomment it then code will not compile
        }
        System.out.println("after try catch block");
        return 10;
    }
    public static void main(String arr[])
    {
        System.out.println(get());
    }
}
