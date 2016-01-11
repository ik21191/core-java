package file;
import java.io.*;
public class CreateList3
{
    public static void main(String arr[])throws Exception
    {
        //String dir=arr[0];
        BufferedReader br=new BufferedReader(new FileReader(new File("C:/Imran/a/input.csv")));
        String line=null;
        while((line=br.readLine())!=null)
        {
            File file1=new File("C:/Imran/a/test/"+line);
            if(file1.renameTo(new File("C:/Imran/a/test2/"+"_s"+line)))
                System.out.println(line+"   moved.");
            else
                System.out.println("Not Moved");
        }
     }
}
