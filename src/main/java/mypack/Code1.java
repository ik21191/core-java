package mypack;
import java.io.*;
import java.sql.*;
import javax.swing.JOptionPane;
public class Code1
{
    public static void main(String arr[])
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/test","root","root");
            Statement stmt=con.createStatement();
            try
            {
                long total=0;long inst=0;
                String input=JOptionPane.showInputDialog("Enter folder name :");
                File file=new File("/root/Desktop/"+input);
                String myfile=null;
                if(file.isDirectory())
                {
                    File list[]=file.listFiles();
                    for(int i=0;i<list.length;i++)
                    {
                        myfile=list[i].getAbsolutePath();
                        BufferedReader br=new BufferedReader(new FileReader(myfile));
                        String line=null;
                        while((line=br.readLine())!=null)
                        {total++;
                            System.out.println("hello");
                            String msisdn=line;
                            System.out.println(msisdn);
                            String query = "INSERT INTO temp1 VALUES (" + msisdn+ ")";
                            try{stmt.executeUpdate(query);}catch(Exception e){inst++;System.out.println(e);}	
                        }
                    }
                    System.out.println("Total nos. of line iserted  "+(total-inst));
                }
                else
                {
                    System.out.println("Wrong entry.");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}


