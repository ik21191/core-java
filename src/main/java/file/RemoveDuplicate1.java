package file;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class RemoveDuplicate1
{
    public static void main(String arr[])throws Exception
    {
        BufferedReader br=new BufferedReader(new FileReader(new File("C:/Imran/xxx.csv")));
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
            String a3=a1+a2;
            if(set.add(a3)){}
            else
            {
                //System.out.println(id+","+a1+","+a2);
                out.println(id+","+a1+","+a2);
            }
         }
    }
}