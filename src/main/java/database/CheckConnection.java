package database;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Set;
import java.util.StringTokenizer;
public class CheckConnection
{
    public static void main(String arr[])
    {
        System.out.println("Program started.");
        try
        {
            BufferedReader bdr=new BufferedReader(new FileReader("e://xx.csv"));
            PrintWriter out=new PrintWriter(new FileWriter("e://yy.csv"),true);
            String line=null;
            StringTokenizer st=null;
            //HashMap<String,String> set=new HashMap<String,String>();
            while((line=bdr.readLine())!=null)
            {
                st=new StringTokenizer(line,",");
                String a1=st.nextToken();
                String a2=st.nextToken();
                //out.println(st.nextToken());
            
            //Set<Map.Entry<String,String>> s=set.entrySet();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/imran","root","imran");
               PreparedStatement stm=con.prepareStatement("select n2 from n3 where n1=?");
                stm.setString(1,a2);
            ResultSet rset=stm.executeQuery();
            while(rset.next())
            {
                out.println(a1+","+rset.getString(1));
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
