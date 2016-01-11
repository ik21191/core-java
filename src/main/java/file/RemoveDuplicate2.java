package file;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class RemoveDuplicate2
{
    public static void main(String arr[])throws Exception
    {
        BufferedReader br=new BufferedReader(new FileReader(new File("C:/Imran/folder1.csv")));
        PrintWriter out=new PrintWriter(new FileWriter("c:/Imran/outfile.csv",true),true);
        Set<String> set=new HashSet<String>();
        String line=null;
        StringTokenizer token=null;
        int i=0;
        while((line=br.readLine())!=null)
        {
            token=new StringTokenizer(line,",");
            String id=token.nextToken();
            String a1=token.nextToken();
            String a2=token.nextToken();
            String a10=a1+a2;
            if(set.add(a10)){}
            else
            {
                //System.out.println(id+","+a1+","+a2);
                out.println(id+","+a1+","+a2);
            }
         }
    }
}