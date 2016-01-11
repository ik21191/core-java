package file;
import java.io.*;
import java.sql.*;
import java.util.StringTokenizer;
public class Tt2
{
    public static void main(String arr[])
    {
        System.out.println("Program started.");
        try
        {
            BufferedReader bdr=new BufferedReader(new FileReader("D:/WORKPLACE/16_11/Secret_DND_20.txt"));
            PrintWriter out=new PrintWriter(new FileWriter("d:/secret.txt"),true);
            String line=null;
            StringTokenizer st=null;
            while((line=bdr.readLine())!=null)
            {
                st=new StringTokenizer(line,",");
                st.nextToken();
                out.println(st.nextToken());
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Program ended.");
    }
}
