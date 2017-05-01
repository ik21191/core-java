package io;

import java.io.*;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintStreamPrintWriter1 
{
    public static void main(String arr[])throws Exception
    {
        //PrintStream out=new PrintStream(new FileOutputStream("c://imran/imran.txt"),true);
        PrintWriter out=new PrintWriter(new FileWriter("c://imran/imran.txt"),true);
        Scanner in=new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter text to print on file and no or No to stop.....");
            String s=in.nextLine();
            if(s.equalsIgnoreCase("no"))
                break;
            else
                out.println(s);
        }
        out.close();
    }
}
