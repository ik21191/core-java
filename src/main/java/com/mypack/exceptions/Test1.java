package com.mypack.exceptions;
public class Test1
{
    public static void main(String arr[])
    {
        try
        {
            try
            {
                int x=1/0;
                try
                {
                    int a=1/0;
                    
                }catch(Exception e)
                {
                    System.out.println("3");
                }
            }catch(Exception e)
            {
                System.out.println("2");
            }
        }catch(Exception e)
        {
            System.out.println("1");
        }
    }
}
