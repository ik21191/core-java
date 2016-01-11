package file;
import java.io.*;
import java.util.*;
import java.util.Set;
import java.util.StringTokenizer;
public class CompareListItem2
{
    public static void main(String arr[])throws Exception
    {
        BufferedReader br=new BufferedReader(new FileReader(new File("C:/Imran/list1.csv")));
        BufferedReader br1=new BufferedReader(new FileReader(new File("C:/Imran/list2.csv")));
        PrintWriter out=new PrintWriter(new FileWriter("c:/Imran/outfile.csv",true),true);
        List<String> list1=new ArrayList<String>();
        String line=null;
        while((line=br.readLine())!=null)
        {
            list1.add(line);
        }
        List<String> list2=new ArrayList<String>();
        while((line=br1.readLine())!=null)
        {
            list2.add(line);
        }
        for(String s:list1)
        {
            for(String s1:list2)
            {
                out.println(s+","+s1);
            }
        }
    }
}