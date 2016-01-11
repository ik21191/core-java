package file;
import java.io.*;
public class CreateList2
{
    public static void main(String arr[])throws Exception
    {
        //String dir=arr[0];
        File file=new File("C:/Imran/a/d5/");
        System.out.println(file.getAbsolutePath());
        PrintWriter out=new PrintWriter(new FileWriter("C:/Imran/filesize.csv",true),true);
        File files[]=file.listFiles();
        for(int i=0;i<files.length;i++)
        {
            out.println(files[i].getName()+","+((files[i].length()/1024)+1));
            System.out.println(files[i].getName()+","+((files[i].length()/1024)+1));
        }
    }
}
