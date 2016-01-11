package file;
import java.io.*;
import java.sql.*;
import java.util.*;
public class FileCollection1
{//Not in use
    public static void main(String arr[])
    {
        System.out.println("Program started.");
        try
        {
            BufferedReader bdr=new BufferedReader(new FileReader("C:/Imran/file1.csv"));
            PrintWriter out=new PrintWriter(new FileWriter("c:/Imran/result.csv"),true);
            String line=null;
            StringTokenizer st=null;
            Set set=new HashSet();
            while((line=bdr.readLine())!=null)
            {
                st=new StringTokenizer(line,",");
                set.add(st.nextToken());
                //out.println(st.nextToken());
            }
            bdr=new BufferedReader(new FileReader("C:/Imran/file1.csv"));
            String check="";
            while((line=bdr.readLine())!=null)
            {
                st=new StringTokenizer(line,",");
                if(set.contains(st.nextToken()))
                {
                    //out.println(st.nextToken());
                    System.out.println(line);
                }
            }
            Iterator itr=set.iterator();
            while(itr.hasNext())
            {
                System.out.println(itr.next());
            }
        }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Program ended.");
    }
}
