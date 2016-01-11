import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.StringTokenizer;
public class InetAddressTest2
{
    public static void main(String[] args)throws Exception
    {  
        String loginId=null;
        String password=null;
        String tokenString;
        URL url=null;
        URLConnection urlcon=null;
        PrintWriter out=new PrintWriter(new FileWriter("c://imran/enc/to.txt"),true);
        InputStream stream=null;
        BufferedReader br,fileReader;
        StringTokenizer token=null;
        fileReader=new BufferedReader(new FileReader("c://Imran/enc/from.csv"));
        int i=0;
        while((tokenString=fileReader.readLine())!=null)
        {
            try
            {
                token=new StringTokenizer(tokenString,",");
                loginId=token.nextToken();
                password=token.nextToken();
                password=URLEncoder.encode(password);
                url = new URL("http://www.fnp.com/flowers/faces/jsp/testPwd.jsp?pwd="+password);
                urlcon = url.openConnection();
                stream = urlcon.getInputStream();
                br=new BufferedReader(new InputStreamReader(stream));
                String line=null;
                br.readLine();br.readLine();br.readLine();br.readLine();line=br.readLine();
                out.println(loginId+","+line+br.readLine());
                System.out.println(i++);
                }catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
