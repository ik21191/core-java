package file;
import java.io.*;
import java.util.StringTokenizer;
public class ReadFolder_Edit
{//
    public static void main(String arr[])throws Exception
    {
        //String dir=arr[0];
        BufferedReader br=new BufferedReader(new FileReader(new File("C:/Imran/a/folder.csv")));
        FileInputStream in=null;
        FileOutputStream out=null;
        String line=null;
        while((line=br.readLine())!=null)
        {
            StringTokenizer str=new StringTokenizer(line,",");
            String token1=str.nextToken();
            String token2=str.nextToken();
            String token3=str.nextToken();
            File file=new File("C:/Imran/a/uk/"+token1);
            if(file.isDirectory())
            {
                File[] files=file.listFiles();
                for(int i=0;i<files.length;i++)
                {
                    String name2=null;
                    File file1=files[i];
                    name2=file1.getName();
                    if(name2.equals(token3))
                    {
                            System.out.println(file1.getAbsolutePath());
                            in=new FileInputStream(file1.getAbsolutePath());
                            out=new FileOutputStream("C:/Imran/a/uk/FINAL/"+token2+".jpg");
                            byte[] buf = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = in.read(buf)) > 0) 
                            {
                                out.write(buf, 0, bytesRead);
                            }
                    }
                    
                }
            }
            
        }
     }
}