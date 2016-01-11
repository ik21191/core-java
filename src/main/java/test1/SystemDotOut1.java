package test1;

import java.io.*;

public class SystemDotOut1
{
    public static void main(String arr[])throws Exception
    {
        PrintStream out=new PrintStream(new FileOutputStream("c://Imran/abc/abc.txt",true));
        System.setOut(out);
        System.out.println("Hello Imran Khan");
    }
}
