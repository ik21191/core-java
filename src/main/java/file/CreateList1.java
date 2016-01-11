package file;
import java.io.*;
public class CreateList1
{
    public static void main(String arr[])throws Exception
    {
        String dir=arr[0];
        File file=new File("C:/Imran/a/"+dir);
        System.out.println(file.getAbsolutePath());
        PrintWriter out=new PrintWriter(new FileWriter("C:/Imran/outfile.csv",true),true);
        File files[]=file.listFiles();
        for(int i=0;i<files.length;i++)
        {
            out.println(files[i].getName());
            System.out.println(i);
        }
    }
}
