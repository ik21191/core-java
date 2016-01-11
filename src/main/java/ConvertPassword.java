import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ConvertPassword {
	
	private static String getPass(String pass) throws Exception {
		//String pass = "c8uVn4+f2P/lwj2vxEUsyg==";
		
		URL url = new URL("http://www.fnp.com/flowers/faces/jsp/testPwd.jsp?pwd="+URLEncoder.encode(pass, "UTF-8"));
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
		//Object obj = connection.getContent();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		String line1 = "";
		while ((line1 = in.readLine()) != null) {
			int index = line1.indexOf(pass);
			if( index > -1 ) {
				int index1 = line1.indexOf("<b>", index);
				int index2 = line1.indexOf("</b>", index);
				in.close();
				return line1.substring(index1+3, index2).trim();
			}
		    System.out.println(line1);
		}

	    in.close();
	    return "notfound";

	}
	
	private static void processFile(String fileName) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		FileOutputStream fos = new FileOutputStream("c://imran/enc/to.txt");
		String line;
		int counter=0;
		while ((line = br.readLine()) != null) {
			counter++;
			//if(counter==3) break;
			String[] address = line.split(",");
			if(address.length > 1) {
				System.out.println("processing:" + (counter)+" "+line);
				String returnPass = getPass(address[1].trim());
				fos.write((address[0]+","+returnPass+"\n").getBytes());
			} else {
				System.out.println("Line not complete: "+ line);
			}
		
			
		}
	
		br.close();
		fos.close();
		
	}
	
	
	public static void main(String[] args) throws Exception {
		if(args.length < 1) System.out.println("Supply file name ");
		
		processFile("c://Imran/enc/from.csv");
		
	}
}
