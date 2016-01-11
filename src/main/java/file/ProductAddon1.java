package file;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class ProductAddon1
{
    public static void main(String arr[])throws Exception
    {
        BufferedReader br=new BufferedReader(new FileReader(new File("C:/Imran/folder.csv")));
        PrintWriter out=new PrintWriter(new FileWriter("c:/Imran/outfile.csv",true),true);
        String line=null;
        StringTokenizer token=null;
        int i=0;
        while((line=br.readLine())!=null)
        {
            token=new StringTokenizer(line,",");
            String id=token.nextToken();
            String a1=token.nextToken();
            String a2=token.nextToken();
            String a3=token.nextToken();
            String a4=token.nextToken();
            String a5=token.nextToken();
            String a6=token.nextToken();
            String a7=token.nextToken();
            String a8=token.nextToken();
            String a9=token.nextToken();
            out.println(id+","+a1);
            out.println(id+","+a2);
            out.println(id+","+a3);
            out.println(id+","+a4);
            out.println(id+","+a5);
            out.println(id+","+a6);
            out.println(id+","+a7);
            out.println(id+","+a8);
            out.println(id+","+a9);
        }
    }
}