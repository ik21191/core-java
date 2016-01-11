package mypack;
import java.io.*;
public class Test4
{
    public static void main(String arr[])throws Exception
    {
        PrintWriter print=new PrintWriter(new FileWriter("/root/Desktop/imran.txt"),true);
        String a="imran";
        print.println(a);
        a="imran";
        print.println(a);
        a="imran";
        print.println(a);
        a="imran";
        print.println(a);
    }
}
