package mypack;
import java.io.*;
public class Test1 
{
    public static void main(String[] args)throws Exception
    {
        long freememory=Runtime.getRuntime().freeMemory();
        System.out.println("Available Memory is :  "+freememory);
        Process process=Runtime.getRuntime().exec("javap java.lang.String");
        BufferedReader br=new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line=null;
        int i=0;
        while(true)
        {
            i++;
            line=br.readLine();
            if(line==null)
                break;
                System.out.println(line);
                
        }
        
    }
}
