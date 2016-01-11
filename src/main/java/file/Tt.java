package file;
import java.io.*;
import java.sql.*;
public class Tt
{
    public static void main(String arr[])
    {
        System.out.println("Program started.");
        try
        {
            BufferedReader bdr=new BufferedReader(new FileReader("d:/mah_obd_base_29oct.txt"));
            PrintWriter out=new PrintWriter(new FileWriter("d:/xyz.txt"),true);
            String line=null;
            while((line=bdr.readLine())!=null)
            {
                String sub=line.substring(0,6);
                if((sub=="9175000"))
                    out.println(sub);
                else
                {
                    
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Program ended.");
    }
}
